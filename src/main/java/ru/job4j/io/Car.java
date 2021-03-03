package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    private final int wheels;
    private final String model;
    private final Engine engine;
    private final String[] passengers;

    public Car(int wheels, String model, Engine engine, String[] passengers) {
        this.wheels = wheels;
        this.model = model;
        this.engine = engine;
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Car{"
                + "wheels = " + wheels
                + ",model = '" + model
                + ",engine = " + engine
                + ",passengers = '" + Arrays.toString(passengers)
                + '}';
    }

    public static void main(String[] args) {
        final Car car = new Car(4, "model S", new Engine("V8"), new String[]{"qwe", "asd", "zxc"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));
        final String carJson =
                "{"
                        + "\"wheels\":4,"
                        + "\"model\":model_S,"
                        + "\"engine\":"
                        + "{"
                        + "\"model\":\"V8\""
                        + "},"
                        + "\"passengers\":"
                        + "[\"qwe\",\"asd\",\"zxc\"]"
                        + "}";
        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);
    }
}
