package org.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HighestParkingLotSelector implements ParkingLotSelector {

    @Override
    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots) {
        List<ParkingLot> notFullParkingLots = parkingLots.stream()
                .filter(ParkingLot::isNotFull)
                .collect(Collectors.toList());

        return notFullParkingLots.stream().max(Comparator.comparing(ParkingLot::getMaximumAvailableSlots)).get();
    }
}
