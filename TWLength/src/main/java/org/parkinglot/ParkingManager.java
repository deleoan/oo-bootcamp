package org.parkinglot;

import org.exceptions.FullParkingException;

import java.util.ArrayList;
import java.util.List;

class ParkingManager extends ParkingBoy{
    private List<ParkingBoy> hiredParkingBoys = new ArrayList<>();

    ParkingManager(List<ParkingLot> parkingLots, String parkingBoyType) {
        super(parkingLots, parkingBoyType);
    }

    @Override
    Ticket parkCar(Car car) throws FullParkingException {
        Ticket parkingTicket;
        if (hiredParkingBoys.isEmpty()) {
            if (parkingLots.isEmpty()) return null;
            parkingTicket =  super.parkCar(car);
            if (parkingTicket != null) return parkingTicket;
            throw new FullParkingException();
        } else {
            parkingTicket = parkingBoyParksCar(car);
            if (parkingTicket != null) return parkingTicket;
        }
        return null;
    }

    private Ticket parkingBoyParksCar(Car car) {
        Ticket parkingTicket;
        for (ParkingBoy hiredParkingBoy : hiredParkingBoys) {
            try {
                parkingTicket = hiredParkingBoy.parkCar(car);
                if (parkingTicket != null) return parkingTicket;
            } catch (FullParkingException e) {
                e.printStackTrace();
                continue;
            }
        }
        return null;
    }

    void hireParkingBoys(List<ParkingBoy> parkingBoys) {
        hiredParkingBoys.addAll(parkingBoys);
    }
}
