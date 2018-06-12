package org.parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void park_car_to_available_slot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

        Assert.assertNotNull(parkingLot.checkSlotAndParkCar(car));
    }

    @Test
    public void parking_lot_is_full(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);

        Assert.assertNull(parkingLot.checkSlotAndParkCar(car));
    }

    @Test
    public void return_parked_car(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.checkSlotAndParkCar(car);

        Assert.assertNotNull(parkingLot.releaseCar(new Ticket(1001)));
    }

    @Test
    public void should_not_return_parked_car_no_ticket(){
        ParkingLot parkingLot = new ParkingLot(1);

        Assert.assertNull(parkingLot.releaseCar(null));
    }

    @Test
    public void no_car_but_with_ticket(){
        Ticket ticket = new Ticket(0001);
        ParkingLot parkingLot = new ParkingLot(1);

        Assert.assertNull(parkingLot.releaseCar(ticket));
    }

    @Test
    public void lot_A_is_full_should_try_to_park_in_lot_B() {
        Car car = new Car();
        ParkingLot parkingLotA = new ParkingLot(0);
        Ticket parkingTicket = parkingLotA.checkSlotAndParkCar(car);

        if (parkingTicket == null) {
            ParkingLot parkingLotB = new ParkingLot(1);
            parkingTicket = parkingLotB.checkSlotAndParkCar(car);

            Assert.assertNotNull(parkingTicket);
        }
    }

    @Test
    public void lot_A_and_B_is_full_should_try_to_park_in_lot_C() {
        Car car = new Car();
        ParkingLot parkingLotA = new ParkingLot(0);
        Ticket parkingTicket = parkingLotA.checkSlotAndParkCar(car);

        if (parkingTicket == null) {
            ParkingLot parkingLotB = new ParkingLot(0);
            parkingTicket = parkingLotB.checkSlotAndParkCar(car);
            if (parkingTicket == null) {
                ParkingLot parkingLotC = new ParkingLot(1);
                parkingTicket = parkingLotC.checkSlotAndParkCar(car);

                Assert.assertNotNull(parkingTicket);
            }
        }
    }

    @Test
    public void cannot_see_car_in_lot_A_pickup_in_lot_B() {
        Ticket parkingTicket = new Ticket(1001);
        ParkingLot parkingLotA = new ParkingLot(0);
        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.checkSlotAndParkCar(new Car());

        Car releasedCar = parkingLotA.releaseCar(parkingTicket);
        if(releasedCar == null) {
            releasedCar = parkingLotB.releaseCar(parkingTicket);

            Assert.assertNotNull(releasedCar);
        }
    }
}
