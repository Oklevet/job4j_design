package ru.job4j.odd.dip.example;

public class Kitten extends Cat implements Basic, Movable, Naming {
    public Kitten(String breed, boolean aliveStatus) {
        super(breed, aliveStatus);
    }

    @Override
    public void sleep() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void canStepping() {

    }

    @Override
    public void canLightRun() {

    }

    @Override
    public String newName() {
        return null;
    }

    @Override
    public void setAliveStatus(boolean aliveStatus) {
        super.setAliveStatus(aliveStatus);
    }

    @Override
    public String getBreed() {
        return super.getBreed();
    }

    @Override
    public boolean isAliveStatus() {
        return super.isAliveStatus();
    }
}
