package org.parkinglot;

import org.exceptions.CarNotFoundException;
import org.exceptions.FullParkingException;

import java.util.ArrayList;
import java.util.List;

class ParkingBoy {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    void parkCars(List<Car> cars) throws FullParkingException {
        for(Car car : cars){
            parkCar(car);
        }
    }

    void parkCar(Car car) throws FullParkingException{
        if(!isAllParkingLotsFull()){
            for(ParkingLot parkingLot : getParkingLots()){
                if(parkingLot.isFull()){
                    continue;
                }
                parkingLot.checkSlotAndParkCar(car);
                break;
            }
        }else{
            throw new FullParkingException();
        }
    }

    void releaseCars(List<Car> cars) throws CarNotFoundException {
        for(Car car : cars){
            releaseCar(car.getTicket());
        }
    }

    Car releaseCar(Ticket ticket) throws CarNotFoundException{
        for(ParkingLot parkingLot : getParkingLots()){
            if(parkingLot.hasCar(ticket)){
                return parkingLot.releaseCar(ticket);
            }
        }
        throw new CarNotFoundException();
    }

    private boolean isAllParkingLotsFull(){
        for(ParkingLot parkingLot : getParkingLots()){
            if(!parkingLot.isFull()){
                return false;
            }
        }
        return true;
    }
}
