package org.parkinglot;

import java.util.HashMap;
import java.util.Map;

class ParkingLotSelectorFactory {
    private static Map<String, ParkingLotSelector> typeToParkingLotSelector = new HashMap<>();

    private static final String NORMAL_PARKING_BOY = "NormalParkingBoy";
    private static final String SMART_PARKING_BOY = "SmartParkingBoy";
    private static final String SUPER_PARKING_BOY = "SuperParkingBoy";

    static {
        typeToParkingLotSelector.put(NORMAL_PARKING_BOY, new FirstParkingLotSelector());
        typeToParkingLotSelector.put(SMART_PARKING_BOY, new HighestParkingLotSelector());
        typeToParkingLotSelector.put(SUPER_PARKING_BOY, new MostAvailableSpaceRateParkingLotSelector());
    }

    static ParkingLotSelector create(String parkingBoyType) throws RuntimeException {
        ParkingLotSelector parkingLotChecker = typeToParkingLotSelector.get(parkingBoyType);
        if (parkingBoyType.isEmpty()) {
            throw new RuntimeException("parkingBoyType is empty");
        }

        return parkingLotChecker;
    }
}
