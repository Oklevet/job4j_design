package ru.job4j.odd.ocp;

import java.util.List;

public class ExampleWrong {
    private static class Car {
        public String move() {
            return "use internal combustion engine";
        }
    }

    private static class Boat {
        public String steer() {
            return "use wind by sail";
        }
        public String repair() {
            return "repair KLIP";
        }
    }

    private static class Plane {
        public String steer() {
            return "turbine engine";
        }
        public String repair() {
            return "repair aerobus a320 tail";
        }
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(new Car(), new Car());
        cars.forEach(Car::move);
    }
}
