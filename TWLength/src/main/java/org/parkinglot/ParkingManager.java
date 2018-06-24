package org.parkinglot;

import org.exceptions.FullParkingException;

import java.util.List;

class ParkingManager{
    private List<ParkingBoy> parkingBoys;
    private ParkingLot parkingLot;


    ParkingManager(List<ParkingBoy> parkingBoys, ParkingLot parkingLot) {
        this.parkingBoys = parkingBoys;
        this.parkingLot = parkingLot;
    }

    Ticket parkCar(Car car) throws FullParkingException {
        Ticket parkingTicket;
        if (parkingBoys.isEmpty()) {
            parkingTicket = parkingLot.checkSlotAndParkCar(car);
            if (parkingTicket != null) return parkingTicket;
            throw new FullParkingException();
        } else {
            for (ParkingBoy parkingBoy : parkingBoys) {
                try {
                    parkingTicket = parkingBoy.parkCar(car);
                } catch (FullParkingException e) {
                    e.printStackTrace();
                    continue;
                }
                if (parkingTicket != null) return parkingTicket;
            }
        }
        return null;
    }
}
