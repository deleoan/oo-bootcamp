package org.parkinglot;

import org.exceptions.CarNotFoundException;
import org.exceptions.FullParkingException;

import java.util.ArrayList;
import java.util.List;

class ParkingBoy {
    protected List<ParkingLot> parkingLots;
    private ParkingLotSelector parkingLotSelector;

    ParkingBoy(List<ParkingLot> parkingLots, String parkingBoyType) {
        this.parkingLots = parkingLots;
        this.parkingLotSelector = ParkingLotSelectorFactory.create(parkingBoyType);
    }

    Ticket parkCar(Car car) throws FullParkingException {
        ParkingLot parkingLot = parkingLotSelector.getAvailableParkingLot(parkingLots);
        if (parkingLot != null) {
            return parkingLot.checkSlotAndParkCar(car);
        }
        throw new FullParkingException();
    }

    Car releaseCar(Ticket ticket) throws CarNotFoundException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.parkedCars.get(ticket) != null) {
                return parkingLot.releaseCar(ticket);
            }
        }
        throw new CarNotFoundException();
    }

    List<Ticket> parkMultipleCars(List<Car> cars) throws FullParkingException {
        List<Ticket> tickets = new ArrayList<>();
        for (Car car : cars) {
            tickets.add(parkCar(car));
        }
        if (tickets.size() > 0) {
            return tickets;
        } else {
            throw new FullParkingException();
        }
    }

    List<Car> releaseMultipleCars(List<Ticket> tickets) throws CarNotFoundException {
        List<Car> returnedCars = new ArrayList<>();
        for (Ticket ticket : tickets) {
            returnedCars.add(releaseCar(ticket));
        }
        if (returnedCars.size() > 0) {
            return returnedCars;
        } else {
            throw new CarNotFoundException();
        }
    }
}
