package org.parkinglot;

import java.util.Comparator;
import java.util.List;

public class MostAvailableSpaceRateParkingLotSelector implements ParkingLotSelector {
    @Override
    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots) {
        if (parkingLots != null) {
            return parkingLots.stream().max(Comparator.comparing(ParkingLot::getParkingLotRate)).get();
        }
        return null;
    }

}
