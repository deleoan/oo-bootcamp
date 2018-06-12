package org.parkinglot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private int availableSlot;
    private List<Car> cars = new ArrayList<>();

    ParkingLot(int availableSlot) {
        this.availableSlot = availableSlot;
    }

    Ticket checkSlotAndParkCar(Car car) {
        if(this.availableSlot > 0 && car != null){
            parkCar(car);
            return car.getTicket();
        }
        return null;
    }

    private void parkCar(Car car) {
        this.availableSlot -= 1;
        cars.add(car);
//        Ticket ticket = new Ticket();
        car.setTicket(new Ticket());
    }

    Car releaseCar(Ticket ticket) {
        for(Car car : this.cars){
            if(car.getTicket() == ticket){
                this.availableSlot+=1;
                return car;
            }
        }
        return null;
    }
}
