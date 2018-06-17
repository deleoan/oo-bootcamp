package org.parkinglot;

import java.util.Comparator;
import java.util.List;

public class MostAvailableSpaceRateParkingLotChecker implements ParkingLotChecker {
    @Override
    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().max(Comparator.comparing(this::getParkingLotRate)).get();
    }

    private float getParkingLotRate(ParkingLot parkingLot) {
//        availableSpace/capacity
//        return (float) parkingLot.getMaximumAvailableSlots()/parkingLot.parkedCars.size();
        return Float.parseFloat(null);
    }
}
