package org.parkinglot;

import org.exceptions.CarNotFoundException;
import org.exceptions.FullParkingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotTest {
    Manager manager;
    ParkingLot parkingLotA, parkingLotB, parkingLotC;

    @Before
    public void setUpTest(){
        manager = new Manager();
    }


    @Test
    public void park_car_to_available_slot() throws FullParkingException {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5);
        Assert.assertNotNull(parkingLot.checkSlotAndParkCar(car));
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
        parkingLot.checkSlotAndParkCar(car);
        Assert.assertNotNull(parkingLot.releaseCar(car.getTicket()));
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

    @Test
    public void lot_A_is_not_full_park_here() throws FullParkingException{
        parkingLotA = new ParkingLot(5);
        parkingLotB = new ParkingLot(5);
        parkingLotC = new ParkingLot(5);

        manager = new Manager();
        manager.getParkingLots().add(parkingLotA);
        manager.getParkingLots().add(parkingLotB);

        Car car = new Car();
        manager.parkCar(car);

        Assert.assertTrue(parkingLotA.hasCar(car.getTicket()));
        Assert.assertTrue(!parkingLotB.hasCar(car.getTicket()));
        Assert.assertTrue(!parkingLotC.hasCar(car.getTicket()));
    }

    @Test
    public void lot_A_is_full_should_try_to_park_in_lot_B() throws FullParkingException{
        parkingLotA = new ParkingLot(0);
        parkingLotB = new ParkingLot(5);
        parkingLotC = new ParkingLot(5);

        manager.getParkingLots().add(parkingLotA);
        manager.getParkingLots().add(parkingLotB);

        Car car = new Car();
        manager.parkCar(car);

        Assert.assertTrue(!parkingLotA.hasCar(car.getTicket()));
        Assert.assertTrue(parkingLotB.hasCar(car.getTicket()));
        Assert.assertTrue(!parkingLotC.hasCar(car.getTicket()));
    }

    @Test(expected = FullParkingException.class)
    public void all_parking_lots_are_full() throws FullParkingException{
        parkingLotA = new ParkingLot(0);
        parkingLotB = new ParkingLot(0);

        manager.getParkingLots().add(parkingLotA);
        manager.getParkingLots().add(parkingLotB);

        Car car = new Car();
        manager.parkCar(car);
    }

    @Test
    public void manager_releases_car() throws CarNotFoundException, FullParkingException{
        parkingLotA = new ParkingLot(5);
        parkingLotB = new ParkingLot(5);

        manager.getParkingLots().add(parkingLotA);
        manager.getParkingLots().add(parkingLotA);

        Car car = new Car();
        manager.parkCar(car);

        Assert.assertEquals(car, manager.releaseCar(car.getTicket()));
    }

    @Test
    public void manager_parks_multiple_cars_and_parking_lots_available() throws FullParkingException{
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add( new Car());
        cars.add(new Car());

        parkingLotA = new ParkingLot(2);
        parkingLotB = new ParkingLot(2);

        manager.getParkingLots().add(parkingLotA);
        manager.getParkingLots().add(parkingLotB);

        manager.parkCars(cars);
    }

    @Test(expected = FullParkingException.class)
    public void manager_parks_multiple_cars_and_not_enough_space() throws FullParkingException{

        List<Car> cars = new ArrayList<>();

        Car carA = new Car();
        Car carB = new Car();
        Car carC = new Car();

        cars.add(carA);
        cars.add(carB);
        cars.add(carC);

        parkingLotA = new ParkingLot(2);
        parkingLotB = new ParkingLot(0);

        manager.getParkingLots().add(parkingLotA);
        manager.getParkingLots().add(parkingLotB);

        manager.parkCars(cars);

    }

    @Test
    public void manager_release_multiple_cars() throws CarNotFoundException, FullParkingException{
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        parkingLotA = new ParkingLot(2);
        parkingLotB = new ParkingLot(2);

        manager.getParkingLots().add(parkingLotA);
        manager.getParkingLots().add(parkingLotB);

        manager.parkCars(cars);
        manager.releaseCars(cars);

        Assert.assertEquals(0, parkingLotA.getCars().size());
        Assert.assertEquals(0, parkingLotB.getCars().size());
    }

    @Test(expected = CarNotFoundException.class)
    public void manager_tries_to_release_unparked_car() throws CarNotFoundException{
        manager.releaseCar(new Ticket());
    }
}
