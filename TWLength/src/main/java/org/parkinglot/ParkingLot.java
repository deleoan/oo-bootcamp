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
        if(checkSlotAvailability() && car != null){
            parkCar(car);
            return car.getCarTicket();
        }
        return null;
    }

    private boolean checkSlotAvailability() {
        return this.availableSlot > 0;
    }

    private void parkCar(Car car) {
        this.availableSlot -= 1;
        cars.add(car);
        int ticketNumber = 1001;
        Ticket ticket = new Ticket(ticketNumber);
        car.setCarTicket(ticket.getTicket());
    }

    Car releaseCar(Ticket ticket) {
        for(Car car : this.cars){
            if(car.getCarTicket().ticketNumber == ticket.ticketNumber){
                this.availableSlot += 1;
                return car;
            }
        }
        return null;
    }
}
