package org.parkinglot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private List<Car> parkingLotA = new ArrayList<>();
    private List<Car> parkingLotB = new ArrayList<>();
    private List<Car> parkingLotC = new ArrayList<>();

    Ticket checkSlotAndParkCar(Car car) {
        if (car != null) {
            if (hasAvailableSlot(parkingLotA)) {
                parkCar(car, parkingLotA);
                return car.getCarTicket();
            } else if (hasAvailableSlot(parkingLotB)) {
                parkCar(car, parkingLotB);
                return car.getCarTicket();
            } else if (hasAvailableSlot(parkingLotC)){
                parkCar(car, parkingLotC);
                return car.getCarTicket();
            } else {
                return null;
            }
        }
        return null;
    }

    private boolean hasAvailableSlot(List<Car> parkingLot) {
        int parkingAvailableSlot = 1;
        return parkingLot.size() < parkingAvailableSlot;
    }

    private void parkCar(Car car, List<Car> parkingLot) {
        parkingLot.add(car);
        int ticketNumber = 1001;
        Ticket ticket = new Ticket(ticketNumber);
        car.setCarTicket(ticket.getTicket());
    }

    Car releaseCar(Ticket ticket, String parkingLot) {
        List<Car> parking = getParkingLot(parkingLot);
        assert parking != null;
        for(Car car : parking){
            if(car.getCarTicket().ticketNumber == ticket.ticketNumber){
                parking.remove(0);
                return car;
            }
        }
        return null;
    }

    private List<Car> getParkingLot(String parkingLot) {
        if (!parkingLot.isEmpty()) {
            switch (parkingLot) {
                case "parkingLotA":
                    return new ArrayList<>(parkingLotA);
                case "parkingLotB":
                    return new ArrayList<>(parkingLotB);
                case "parkingLotC":
                    return new ArrayList<>(parkingLotC);
            }
        }
        return null;
    }
}
