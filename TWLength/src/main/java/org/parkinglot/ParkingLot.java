package org.parkinglot;

import org.exceptions.CarNotFoundException;
import org.exceptions.FullParkingException;

import java.util.HashMap;

class ParkingLot {
    private int maximumSlots;
    HashMap<Ticket, Car> parkedCars;

    ParkingLot(int maximumSlots){
        this.maximumSlots = maximumSlots;
        this.parkedCars = new HashMap<>();
    }

    Ticket checkSlotAndParkCar(Car car) throws FullParkingException {
        if (isFull() && car != null) {
            Ticket ticket = new Ticket();
            parkCar(car, ticket);
            return ticket;
        }
        throw new FullParkingException();
    }

    private void parkCar(Car car, Ticket ticket) {
        parkedCars.put(ticket, car);
        this.maximumSlots--;
    }

    Car releaseCar(Ticket ticket) throws CarNotFoundException {
        if(parkedCars.containsKey(ticket)) {
            this.maximumSlots++;
            return parkedCars.remove(ticket);
        }
        throw new CarNotFoundException();
    }

    boolean isFull() {
        return this.maximumSlots != 0;
    }

    int getMaximumAvailableSlots() {
        return this.maximumSlots;
    }
}
