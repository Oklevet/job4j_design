package ru.job4j.odd.isp;

public class Example {
}

interface StartEngine {
    public void checkFuel();
    public void startEngine();
}

interface Drive {
    public void drive();
}

interface Flying {
    public void fly();
    public void openFlaps();
}

interface Lights {
    public void turnSignals();
}

class Planes implements StartEngine, Drive, Flying {
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
    public void openFlaps() {

    }
}

class Cars implements StartEngine, Drive, Lights {
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
    public void turnSignals() {

    }
}