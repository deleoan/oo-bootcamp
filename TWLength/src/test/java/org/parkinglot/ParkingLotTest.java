package org.parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void test_park_car_to_available_slot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Assert.assertNotNull(parkingLot.addCarAndCheckSlot(car));
    }

    @Test
    public void test_parking_lot_is_full(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);
        Assert.assertNull(parkingLot.addCarAndCheckSlot(car));
    }

    @Test
    public void test_return_parked_car(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.addCarAndCheckSlot(car);
        Assert.assertNotNull(parkingLot.releaseCar(car.getTicket()));
    }

    @Test
    public void test_should_not_return_parked_car_no_ticket(){
        ParkingLot parkingLot = new ParkingLot(1);
        Assert.assertNull(parkingLot.releaseCar(null));
    }

    @Test
    public void test_no_car_but_with_ticket(){
        Ticket ticket = new Ticket();
        ParkingLot parkingLot = new ParkingLot(1);
        Assert.assertNull(parkingLot.releaseCar(ticket));
    }
}
