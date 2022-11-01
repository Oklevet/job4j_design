package ru.job4j.odd.lsp.parking;

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
         * next if - заглушка для теста
         */
        if (nums == -10) {
            return false;
        }
        return true;
    }

    @Override
    public void enterVehicle(Vehicle vehicle) throws Exception {
        if (vehicle.size > 1) {
             if (occupiedSpaceTruck < maxSpaceTruck) {
                occupiedSpaceTruck++;
            } else if (maxSpacePass - occupiedSpacePass >= vehicle.size) {
                if (checkNeighboring(vehicle.size)) {
                    occupiedSpacePass += vehicle.size;
                }
            } else {
                throw new Exception("No spaces for truck of this size.");
            }
        } else {
            if (occupiedSpacePass < maxSpacePass) {
                occupiedSpacePass++;
            } else {
                throw new Exception("Passenger car parking is full.");
            }
        }
    }

    @Override
    public void leftVehicle(Vehicle vehicle) throws Exception {
        if (vehicle.size > 1) {
            if (occupiedSpaceTruck < 1) {
            throw new Exception("No trucks in parking. Parking counter is broken.");
            }
            occupiedSpaceTruck--;
        } else {
            if (occupiedSpacePass < 1) {
                throw new Exception("No passenger cars in parking. Is it a ghost? Parking counter is broken.");
            }
            occupiedSpacePass--;
            }
    }

    public int getOccupiedSpacePass() {
        return occupiedSpacePass;
    }

    public int getOccupiedSpaceTruck() {
        return occupiedSpaceTruck;
    }
}
