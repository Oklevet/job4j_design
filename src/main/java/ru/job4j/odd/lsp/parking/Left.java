package ru.job4j.odd.lsp.parking;

import ru.job4j.io.Car;

public interface Left {
    public void leftTruck(Truck truck) throws Exception;
    public void leftPassCar(PassengerCar car) throws Exception;
}