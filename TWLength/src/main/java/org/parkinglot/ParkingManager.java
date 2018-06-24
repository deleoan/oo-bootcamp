package org.parkinglot;

import org.exceptions.FullParkingException;

import java.util.List;

public class ParkingManager extends ParkingBoy {
    public static final String SUPER_PARKING_BOY = "SuperParkingBoy";
    private List<ParkingBoy> parkingBoys;

    ParkingManager(List<ParkingLot> parkingLots, String parkingBoyType) {
        super(parkingLots, parkingBoyType);

    }

//    public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
//        this.parkingLots = parkingLots;
//        this.parkingBoys = parkingBoys;
//    }

    @Override
    public Ticket parkCar(Car car) throws FullParkingException {
        if (parkingBoys.isEmpty()) {
            ParkingBoy parkingBoy = new ParkingBoy(parkingLots, SUPER_PARKING_BOY);
            return parkingBoy.parkCar(car);
        } else {
            for (ParkingBoy parkingBoy : parkingBoys) {
                return parkingBoy.parkCar(car);
            }
        }
        return null;
    }
}
