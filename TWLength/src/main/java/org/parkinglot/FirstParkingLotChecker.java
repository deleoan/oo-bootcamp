package org.parkinglot;

import java.util.List;

class FirstParkingLotChecker implements ParkingLotChecker{

    @Override
    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots) {
        for(ParkingLot parkingLot : parkingLots){
            if(parkingLot.isFull()){
                return parkingLot;
            }
        }
        return null;
    }
}
