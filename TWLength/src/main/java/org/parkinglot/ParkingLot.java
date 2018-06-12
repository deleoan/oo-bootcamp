package org.parkinglot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private int maximumSlot;
    private List<Car> cars = new ArrayList<>();

    ParkingLot(int maximumSlot) {
        this.maximumSlot = maximumSlot;
    }

    Ticket addCarAndCheckSlot(Car car) {
        if(this.maximumSlot > 0 && car != null){
            addCar(car);
            return car.getTicket();
        }
        return null;
    }

    private void addCar(Car car) {
        this.maximumSlot -= 1;
        cars.add(car);
        car.setTicket(new Ticket());
    }

    Car releaseCar(Ticket ticket) {
        for(Car car : this.cars){
            if(car.getTicket()==ticket){
                this.maximumSlot+=1;
                return car;
            }
        }
        return null;
    }
}
