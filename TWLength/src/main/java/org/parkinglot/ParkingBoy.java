package org.parkinglot;

import org.exceptions.CarNotFoundException;
import org.exceptions.FullParkingException;

import java.util.ArrayList;
import java.util.List;

class ParkingBoy {
    private final String parkingBoyType;
    private List<ParkingLot> parkingLots;

    ParkingBoy(List<ParkingLot> parkingLots, String parkingBoyType) {
        this.parkingLots = parkingLots;
        this.parkingBoyType = parkingBoyType;
    }

    private ParkingLot getParkingLot(String parkingBoyType) {
        ParkingLotChecker parkingLotChecker = null;
        if(parkingBoyType.equals("NormalParkingBoy")) {
            parkingLotChecker = new FirstParkingLotChecker();
        } else if (parkingBoyType.equals("SmartParkingBoy")) {
            parkingLotChecker = new HighestParkingLotChecker();
        }
        assert parkingLotChecker != null;
        return parkingLotChecker.getAvailableParkingLot(parkingLots);
    }

    Ticket parkCar(Car car) throws FullParkingException {
        ParkingLot parkingLot = getParkingLot(parkingBoyType);
        if (parkingLot != null) {
            return parkingLot.checkSlotAndParkCar(car);
        }
        throw new FullParkingException();
    }

    Car releaseCar(Ticket ticket) throws CarNotFoundException {
        for(ParkingLot parkingLot : parkingLots){
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
        if(returnedCars.size() > 0) {
            return returnedCars;
        } else {
            throw new CarNotFoundException();
        }
    }
}
