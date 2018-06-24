package org.parkinglot;

import org.exceptions.CarNotFoundException;
import org.exceptions.FullParkingException;

import java.util.HashMap;

class ParkingLot {
    private int maximumSlots;
    private int availableSpace;
    HashMap<Ticket, Car> parkedCars;
    ParkingLot(int maximumSlots){
        this.maximumSlots = maximumSlots;
        this.availableSpace = maximumSlots;
        this.parkedCars = new HashMap<>();
    }

    Ticket checkSlotAndParkCar(Car car) throws FullParkingException {
        if (isNotFull() && car != null) {
            Ticket ticket = new Ticket();
            parkCar(car, ticket);
            return ticket;
        }
        throw new FullParkingException();
    }

    private void parkCar(Car car, Ticket ticket) {
        parkedCars.put(ticket, car);
        this.availableSpace--;
    }

    Car releaseCar(Ticket ticket) throws CarNotFoundException {
        if(parkedCars.containsKey(ticket)) {
            this.availableSpace++;
            return parkedCars.remove(ticket);
        }
        throw new CarNotFoundException();
    }

    boolean isNotFull() {
        return this.availableSpace != 0;
    }

    int getMaximumAvailableSlots() {
        return this.maximumSlots;
    }

    private int getAvailableSpace() {
        return this.availableSpace;
    }

    float getParkingLotRate() {
        return (float) getAvailableSpace()/(float) getMaximumAvailableSlots() * 100;
    }
}
