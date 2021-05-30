package ru.job4j.odd.lsp.parking;

import ru.job4j.io.Car;

public class ParkState implements Entered, Left, Neighboring {
    private int occupiedSpacePass;

    private int occupiedSpaceTruck;
    private final int maxSpaceTruck;
    private final int maxSpacePass;

    public ParkState(Parking parking) {
        this.maxSpaceTruck = parking.getSpaceTruck();
        this.maxSpacePass = parking.getSpacePassCar();
    }

    @Override
    public boolean checkNeighboring(int nums) {
        /**
         * Some logic, for neighboring.
         * Stack of nums consecutive spaces in groups by their places in this parking
         */
        if (nums == -10) {  //заглушка для теста
            return false;
        }
        return true;
    }

    @Override
    public void enterTruck(Truck truck) throws Exception {
        if (occupiedSpacePass + truck.size <= maxSpaceTruck) {
            if (checkNeighboring(truck.size)) {
                occupiedSpaceTruck += truck.size;
            }
        } else if (maxSpacePass - occupiedSpacePass >= truck.size) {
            if (checkNeighboring(truck.size)) {
                occupiedSpacePass += truck.size;
            }
        } else {
            throw new Exception("No spaces for truck of this size.");
        }
    }

    @Override
    public void enterPassCar(PassengerCar car) throws Exception {
        if (occupiedSpacePass < maxSpacePass) {
            occupiedSpacePass++;
        } else {
            throw new Exception("Passenger car parking is full.");
        }
    }

    @Override
    public void leftTruck(Truck truck) throws Exception {
        if (occupiedSpaceTruck < 1) {
            throw new Exception("No trucks in parking. Is it a ghost? Parking counter is broken.");
        }
        if (occupiedSpaceTruck < truck.size) {
            throw new Exception("Trucks of this size cant be in parking. Parking counter is broken.");
        }
        occupiedSpaceTruck -= truck.size;
    }

    @Override
    public void leftPassCar(PassengerCar car) throws Exception {
        if (occupiedSpacePass < 1) {
            throw new Exception("No passenger cars in parking. Is it a ghost? Parking counter is broken.");
        }
        occupiedSpacePass--;
    }

    public int getOccupiedSpacePass() {
        return occupiedSpacePass;
    }

    public int getOccupiedSpaceTruck() {
        return occupiedSpaceTruck;
    }
}
