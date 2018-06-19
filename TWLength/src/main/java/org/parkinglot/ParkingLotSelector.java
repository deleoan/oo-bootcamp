package org.parkinglot;

import java.util.List;

public interface ParkingLotSelector {
    ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots);
}
