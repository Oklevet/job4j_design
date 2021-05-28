package ru.job4j.odd.ocp;

import java.util.List;

public class Example {
    private interface Steerable {
        String steer();
    }

    private interface Repairable {
        String repair();
    }

    private interface RepairAnchor extends Repairable {
        String repair();
    }

    private interface RepairTail extends Repairable {
        String repair();
    }

    private static class Car implements Steerable {
        @Override
        public String steer() {
            return "use internal combustion engine";
        }
    }

    private static class Boat implements Steerable, RepairAnchor {
        @Override
        public String steer() {
            return "use wind by sail";
        }

        @Override
        public String repair() {
            return "repair KLIP";
        }
    }

    private static class Plane implements Steerable, RepairTail {
        @Override
        public String steer() {
            return "turbine engine";
        }

        @Override
        public String repair() {
            return "repair aerobus a320 tail";
        }
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(new Car(), new Car());
        cars.forEach(Car::steer);
    }
}
