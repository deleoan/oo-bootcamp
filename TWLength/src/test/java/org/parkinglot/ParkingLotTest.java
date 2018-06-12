package org.parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void park_car_to_available_slot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        Assert.assertNotNull(parkingLot.checkSlotAndParkCar(car));
    }

    @Test
    public void parking_lot_is_full(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.checkSlotAndParkCar(car);
        parkingLot.checkSlotAndParkCar(car);
        parkingLot.checkSlotAndParkCar(car);

        Assert.assertNull(parkingLot.checkSlotAndParkCar(car));
    }

    @Test
    public void return_parked_car(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.checkSlotAndParkCar(car);

        Assert.assertNotNull(parkingLot.releaseCar(new Ticket(1001), "parkingLotA"));
    }

    @Test
    public void should_not_return_parked_car_no_ticket(){
        ParkingLot parkingLot = new ParkingLot();

        Assert.assertNull(parkingLot.releaseCar(null, "parkingLotA"));
    }

    @Test
    public void no_car_but_with_ticket(){
        Ticket ticket = new Ticket(0001);
        ParkingLot parkingLot = new ParkingLot();

        Assert.assertNull(parkingLot.releaseCar(ticket, "parkingLotA"));
    }

    @Test
    public void lot_A_is_full_should_try_to_park_in_lot_B() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.checkSlotAndParkCar(car);

        Assert.assertNotNull(parkingLot.checkSlotAndParkCar(car));
    }

    @Test
    public void lot_A_and_B_is_full_should_try_to_park_in_lot_C() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.checkSlotAndParkCar(car);
        parkingLot.checkSlotAndParkCar(car);

        Assert.assertNotNull(parkingLot.checkSlotAndParkCar(car));
    }

    @Test
    public void car_not_in_lot_A_pickup_in_lot_B() {
        Ticket parkingTicket = new Ticket(1001);
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.checkSlotAndParkCar(car);
        parkingLot.checkSlotAndParkCar(car);

        Assert.assertNotNull(parkingLot.releaseCar(parkingTicket, "parkingLotB"));
    }

}
