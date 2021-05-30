package ru.job4j.odd.isp;

public class ExampleWrong {
}

interface Start {
    public void checkFuel();
    public void startEngine();
    public void drive();
    public void fly();
    public void turnSignals();
    public void openFlaps();
}

class Plane implements Start {
    @Override
    public void checkFuel() {
    }

    @Override
    public void startEngine() {
    }

    @Override
    public void drive() {
    }

    @Override
    public void fly() {
    }

    @Override
    public void turnSignals() {
        System.out.println("Not implemented.");
    }

    @Override
    public void openFlaps() {
    }
}

class Car implements Start {
    @Override
    public void checkFuel() {
    }

    @Override
    public void startEngine() {
    }

    @Override
    public void drive() {
    }

    @Override
    public void fly() {
        System.out.println("Not implemented.");
    }

    @Override
    public void turnSignals() {
    }

    @Override
    public void openFlaps() {
        System.out.println("Not implemented.");
    }
}
