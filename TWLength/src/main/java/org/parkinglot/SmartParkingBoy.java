package org.parkinglot;

import org.exceptions.FullParkingException;

import java.util.ArrayList;
import java.util.List;

class SmartParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    void parkCars(List<Car> cars) throws FullParkingException {
        ParkingLot parkingLotA = getParkingLots().get(0);
        ParkingLot parkingLotB = getParkingLots().get(1);
        int parkingLotASlot = parkingLotA.maximumSlots;
        int parkingLotBSlot = parkingLotB.maximumSlots;

        if (parkingLotASlot == 0 && parkingLotBSlot == 0) {
            throw new FullParkingException();
        } else {
            if (parkingLotASlot == parkingLotBSlot) {
                for(Car car : cars){
                    parkCar(car, parkingLotA);
                }
            } else {
                if (parkingLotASlot > parkingLotBSlot) {
                    for(Car car : cars){
                        parkCar(car, parkingLotA);
                    }
                } else {
                    for(Car car : cars){
                        parkCar(car, parkingLotB);
                    }
                }
            }

        }

    }

    private void parkCar(Car car, ParkingLot parkingLot) throws FullParkingException {
        parkingLot.checkSlotAndParkCar(car);
    }
}
