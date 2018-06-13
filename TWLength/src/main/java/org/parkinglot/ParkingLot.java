package org.parkinglot;

import org.exceptions.CarNotFoundException;
import org.exceptions.FullParkingException;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private int maximumSlots;

    private List<Car> cars = new ArrayList<>();

    ParkingLot(int maximumSlots){
        this.maximumSlots = maximumSlots;
    }

    List<Car> getCars() {
        return cars;
    }

    Ticket checkSlotAndParkCar(Car car) throws FullParkingException {
        if (!isFull() && car != null) {
            parkCar(car);
            return car.getTicket();
        }
        throw new FullParkingException();
    }

    private void parkCar(Car car) {
        Ticket ticket = new Ticket();
        car.setTicket(ticket);
        getCars().add(car);
        this.maximumSlots-=1;
    }

    Car releaseCar(Ticket ticket) throws CarNotFoundException {
        for(Car car: this.cars){
            if(car.getTicket().equals(ticket)){
                this.maximumSlots+=1;
                cars.remove(car);
                return car;
            }
        }
        throw new CarNotFoundException();
    }

    boolean hasCar(Ticket ticket){
        for(Car parkedCar : getCars()){
            if(parkedCar.getTicket().equals(ticket)){
                return true;
            }
        }
        return false;
    }

    boolean isFull() {
        return this.maximumSlots == 0;
    }
}
