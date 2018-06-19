package org.parkinglot;

import java.util.List;

public class FirstParkingLotSelector implements ParkingLotSelector {

    @Override
    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots) {
        for(ParkingLot parkingLot : parkingLots){
            if(parkingLot.isNotFull()){
                return parkingLot;
            }
        }
        return null;
    }
}
