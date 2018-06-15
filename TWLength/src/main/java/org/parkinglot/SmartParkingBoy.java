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

    }

    private void parkCar(Car car, ParkingLot parkingLot) throws FullParkingException {
        parkingLot.checkSlotAndParkCar(car);
    }
}
