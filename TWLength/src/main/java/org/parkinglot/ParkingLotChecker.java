package org.parkinglot;

import java.util.List;

public interface ParkingLotChecker {
    ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots);
}
