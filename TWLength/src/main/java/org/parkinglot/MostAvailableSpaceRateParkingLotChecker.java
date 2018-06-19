package org.parkinglot;

import java.util.Comparator;
import java.util.List;

public class MostAvailableSpaceRateParkingLotChecker implements ParkingLotChecker {
    @Override
    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().max(Comparator.comparing(this::getParkingLotRate)).get();
    }

    private float getParkingLotRate(ParkingLot parkingLot) {
        return (float) parkingLot.getAvailableSpace()/(float) parkingLot.getMaximumAvailableSlots() * 100;
    }
}
