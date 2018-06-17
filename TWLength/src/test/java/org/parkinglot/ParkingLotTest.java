package org.parkinglot;

import org.exceptions.CarNotFoundException;
import org.exceptions.FullParkingException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotTest {

    @Test
    public void park_car_to_available_slot() throws FullParkingException {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5);
        Ticket ticket = parkingLot.checkSlotAndParkCar(car);
        Assert.assertNotNull(ticket);
    }

    @Test(expected = FullParkingException.class)
    public void parking_lot_is_full() throws FullParkingException{
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);
        parkingLot.checkSlotAndParkCar(car);
    }

    @Test
    public void return_parked_car() throws FullParkingException, CarNotFoundException {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5);
        Ticket ticket = parkingLot.checkSlotAndParkCar(car);
        Assert.assertNotNull(parkingLot.releaseCar(ticket));
    }

    @Test(expected = CarNotFoundException.class)
    public void should_not_return_parked_car_no_ticket() throws CarNotFoundException{
        ParkingLot parkingLot = new ParkingLot(5);
        Assert.assertNull(parkingLot.releaseCar(null));
    }

    @Test(expected = CarNotFoundException.class)
    public void no_car_but_with_ticket() throws CarNotFoundException{
        Ticket ticket = new Ticket();
        ParkingLot parkingLot = new ParkingLot(5);
        Assert.assertNull(parkingLot.releaseCar(ticket));
    }

    //Requirement 2
    @Test
    public void given_parking_lot_A_not_full_when_park_car_should_return_ticket() throws FullParkingException{
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(5));
        parkingLots.add(new ParkingLot(5));
        parkingLots.add(new ParkingLot(5));

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, "NormalParkingBoy");
        Car car = new Car();
        Ticket ticket = parkingBoy.parkCar(car);

        Assert.assertNotNull(ticket);
    }

    @Test
    public void given_parking_lot_A_full_when_park_car_should_park_in_lot_B_and_return_ticket() throws FullParkingException{
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(5));
        parkingLots.add(new ParkingLot(5));

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, "NormalParkingBoy");
        Car car = new Car();
        Ticket ticket = parkingBoy.parkCar(car);

        Assert.assertNotNull(ticket);
    }

    @Test(expected = FullParkingException.class)
    public void given_all_parking_lots_are_full_when_park_car_should_throw_exception() throws FullParkingException{
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(0));

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, "NormalParkingBoy");
        Car car = new Car();
        parkingBoy.parkCar(car);
    }

    @Test
    public void manager_releases_car() throws CarNotFoundException, FullParkingException{
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(5));
        parkingLots.add(new ParkingLot(5));
        parkingLots.add(new ParkingLot(5));

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, "NormalParkingBoy");
        Car car = new Car();
        Ticket ticket = parkingBoy.parkCar(car);

        Assert.assertNotNull(parkingBoy.releaseCar(ticket));
    }

    @Test
    public void manager_parks_multiple_cars_and_parking_lots_available() throws FullParkingException{
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(3));
        parkingLots.add(new ParkingLot(3));
        parkingLots.add(new ParkingLot(3));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, "NormalParkingBoy");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        parkingBoy.parkMultipleCars(cars);

        Assert.assertEquals(3, parkingLots.get(0).parkedCars.size());
    }

    @Test(expected = FullParkingException.class)
    public void manager_parks_multiple_cars_and_not_enough_space() throws FullParkingException{
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(2));
        parkingLots.add(new ParkingLot(0));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, "NormalParkingBoy");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        parkingBoy.parkMultipleCars(cars);
    }

    @Test
    public void manager_release_multiple_cars() throws CarNotFoundException, FullParkingException{
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(2));
        parkingLots.add(new ParkingLot(2));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, "NormalParkingBoy");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        List<Ticket> tickets = parkingBoy.parkMultipleCars(cars);

        Assert.assertEquals(3, parkingBoy.releaseMultipleCars(tickets).size());

    }

    @Test
    public void given_highest_parking_slot_when_park_car_return_ticket() throws Exception {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot(5));

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, "SmartParkingBoy");
        Car car = new Car();
        Ticket ticket = parkingBoy.parkCar(car);

        Assert.assertNotNull(ticket);
        Assert.assertEquals(1, parkingLots.get(1).parkedCars.size());
    }

    @Test
    public void given_parking_lot_with_same_lot_count_should_park_car_in_first() throws Exception {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(5));
        parkingLots.add(new ParkingLot(5));

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, "SmartParkingBoy");
        Car car = new Car();
        Ticket ticket = parkingBoy.parkCar(car);

        Assert.assertNotNull(ticket);
        Assert.assertEquals(1, parkingLots.get(0).parkedCars.size());
    }

    //Requirement 3
    @Test
    public void given_() {

    }
}
