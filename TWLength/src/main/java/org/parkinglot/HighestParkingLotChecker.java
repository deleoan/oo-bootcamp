package org.parkinglot;

import java.util.Comparator;
import java.util.List;

public class HighestParkingLotChecker implements ParkingLotChecker{

    @Override
    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = getHighestCapacityParkingLot(parkingLots);
        if (parkingLot.getAvailableSpace() != 0) {
            return parkingLot;
        }
        return getHighestCapacityParkingLot(parkingLots);
    }

    private ParkingLot getHighestCapacityParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().max(Comparator.comparing(ParkingLot::getMaximumAvailableSlots)).get();
    }
}
