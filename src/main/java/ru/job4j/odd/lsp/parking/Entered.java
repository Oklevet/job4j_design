package ru.job4j.odd.lsp.parking;

import ru.job4j.io.Car;

public interface Entered {
    public void enterTruck(Truck truck) throws Exception;
    public void enterPassCar(PassengerCar car) throws Exception;
}
