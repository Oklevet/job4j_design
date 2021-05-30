package ru.job4j.odd.lsp.parking;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParkStateTest {

    @Test
    public void validCarPass() throws Exception {
        ParkState parkState = new ParkState(new Parking(10, 0));
        PassengerCar car1 = new PassengerCar();
        PassengerCar car2 = new PassengerCar();
        parkState.enterPassCar(car1);
        parkState.enterPassCar(car2);
        assertThat(parkState.getOccupiedSpacePass(), is(2));
    }

    @Test
    public void validTruck() throws Exception {
        ParkState parkState = new ParkState(new Parking(0, 10));
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(2);
        parkState.enterTruck(truck1);
        parkState.enterTruck(truck2);
        assertThat(parkState.getOccupiedSpaceTruck(), is(6));
    }

    @Test
    public void validLeftTruck() throws Exception {
        ParkState parkState = new ParkState(new Parking(0, 10));
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(2);
        parkState.enterTruck(truck1);
        parkState.enterTruck(truck2);
        parkState.leftTruck(truck1);
        assertThat(parkState.getOccupiedSpaceTruck(), is(2));
    }

    @Test
    public void validTruckOnPassesSpaces() throws Exception {
        ParkState parkState = new ParkState(new Parking(10, 4));
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(2);
        parkState.enterTruck(truck1);
        parkState.enterTruck(truck2);
        assertThat(parkState.getOccupiedSpacePass(), is(2));
        assertThat(parkState.getOccupiedSpaceTruck(), is(4));
    }

    @Test
    public void validTruckOnPassesSpacesWhenTooBigToTruck() throws Exception {
        ParkState parkState = new ParkState(new Parking(10, 2));
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(2);
        parkState.enterTruck(truck1);
        parkState.enterTruck(truck2);
        assertThat(parkState.getOccupiedSpacePass(), is(4));
        assertThat(parkState.getOccupiedSpaceTruck(), is(2));
    }

    @Test (expected = Exception.class)
    public void invalidTruckWhenTooBig() throws Exception {
        ParkState parkState = new ParkState(new Parking(0, 2));
        Truck truck1 = new Truck(4);
        parkState.enterTruck(truck1);
    }

    @Test (expected = Exception.class)
    public void invalidPassCars() throws Exception {
        ParkState parkState = new ParkState(new Parking(2, 2));
        PassengerCar car1 = new PassengerCar();
        PassengerCar car2 = new PassengerCar();
        PassengerCar car3 = new PassengerCar();
        parkState.enterPassCar(car1);
        parkState.enterPassCar(car2);
        parkState.enterPassCar(car3);
    }

    @Test (expected = Exception.class)
    public void invalidNeighboring() throws Exception {
        ParkState parkState = new ParkState(new Parking(1, 6));
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(2);
        parkState.enterTruck(truck1);             //трак1 припарковался на места 2-5 из 1-6. Трак 2 не влезет.
        parkState.checkNeighboring(-10);    //вызов заглушки для получения false в проверке соседства
    }
}