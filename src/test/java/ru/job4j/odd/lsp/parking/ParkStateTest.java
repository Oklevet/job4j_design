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
        parkState.enterVehicle(car1);
        parkState.enterVehicle(car2);
        assertThat(parkState.getOccupiedSpacePass(), is(2));
    }

    @Test
    public void validTruck() throws Exception {
        ParkState parkState = new ParkState(new Parking(0, 10));
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(2);
        parkState.enterVehicle(truck1);
        parkState.enterVehicle(truck2);
        assertThat(parkState.getOccupiedSpaceTruck(), is(2));
    }

    @Test
    public void validLeftTruck() throws Exception {
        ParkState parkState = new ParkState(new Parking(0, 10));
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(2);
        parkState.enterVehicle(truck1);
        parkState.enterVehicle(truck2);
        parkState.leftVehicle(truck1);
        assertThat(parkState.getOccupiedSpaceTruck(), is(1));
    }

    @Test
    public void validTruckOnPassesSpaces() throws Exception {
        ParkState parkState = new ParkState(new Parking(10, 1));
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(2);
        parkState.enterVehicle(truck1);
        parkState.enterVehicle(truck2);
        assertThat(parkState.getOccupiedSpacePass(), is(2));
        assertThat(parkState.getOccupiedSpaceTruck(), is(1));
    }

    @Test
    public void validTruckOnPassesSpacesWhenTooBigToTruck() throws Exception {
        ParkState parkState = new ParkState(new Parking(10, 0));
        Truck truck1 = new Truck(2);
        Truck truck2 = new Truck(4);
        parkState.enterVehicle(truck1);
        parkState.enterVehicle(truck2);
        assertThat(parkState.getOccupiedSpacePass(), is(6));
        assertThat(parkState.getOccupiedSpaceTruck(), is(0));
    }

    @Test (expected = Exception.class)
    public void invalidTruckWhenTooBig() throws Exception {
        ParkState parkState = new ParkState(new Parking(0, 1));
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(4);
        parkState.enterVehicle(truck1);
        parkState.enterVehicle(truck2);
    }

    @Test (expected = Exception.class)
    public void invalidPassCars() throws Exception {
        ParkState parkState = new ParkState(new Parking(2, 2));
        PassengerCar car1 = new PassengerCar();
        PassengerCar car2 = new PassengerCar();
        PassengerCar car3 = new PassengerCar();
        parkState.enterVehicle(car1);
        parkState.enterVehicle(car2);
        parkState.enterVehicle(car3);
    }

    @Test
    public void invalidNeighboring() throws Exception {
        ParkState parkState = new ParkState(new Parking(4, 1));
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(2);
        Truck truck3 = new Truck(2);
        parkState.enterVehicle(truck1);
        parkState.enterVehicle(truck2);
        /**
         * трак2 припарковался на места 2-3 из 1-4. Трак 3 не влезет.
         * вызов заглушки для получения false в проверке соседства
         */
        parkState.enterVehicle(truck3);
        assertFalse(parkState.checkNeighboring(-10));
    }
}