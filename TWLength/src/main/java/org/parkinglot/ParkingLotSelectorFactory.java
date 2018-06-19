package org.parkinglot;

import java.util.HashMap;
import java.util.Map;

class ParkingLotSelectorFactory {
    private static Map<String, ParkingLotSelector> typeToParkingLotSelector = new HashMap<>();

    static {
        typeToParkingLotSelector.put("NormalParkingBoy", new FirstParkingLotSelector());
        typeToParkingLotSelector.put("SmartParkingBoy", new HighestParkingLotSelector());
        typeToParkingLotSelector.put("SuperParkingBoy", new MostAvailableSpaceRateParkingLotSelector());
    }

    static ParkingLotSelector create(String parkingBoyType) throws RuntimeException {
        ParkingLotSelector parkingLotChecker = typeToParkingLotSelector.get(parkingBoyType);
        if (parkingBoyType.isEmpty()) {
            throw new RuntimeException("parkingBoyType is empty");
        }

        return parkingLotChecker;
    }
}
