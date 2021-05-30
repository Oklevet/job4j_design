package ru.job4j.odd.lsp.parking;

public class Parking {
    private final int spacePassCar;
    private final int spaceTruck;

    public Parking(int spacePappCar, int spaceTruck) {
        this.spacePassCar = spacePappCar;
        this.spaceTruck = spaceTruck;
    }

    public int getSpacePassCar() {
        return spacePassCar;
    }

    public int getSpaceTruck() {
        return spaceTruck;
    }
}
