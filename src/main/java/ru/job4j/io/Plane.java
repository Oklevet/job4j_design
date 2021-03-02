package ru.job4j.io;

import java.util.Arrays;

public class Plane {
    private final int wings;
    private final String model;
    private final Engine engine;
    private final String[] passengers;

    public Plane(int wings, String model, Engine engine, String[] passengers) {
        this.wings = wings;
        this.model = model;
        this.engine = engine;
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Car{"
                + "wings = " + wings
                + ",model = '" + model
                + ",engine = " + engine
                + ",passengers = '" + Arrays.toString(passengers)
                + '}';
    }
}