package ru.job4j.odd.dip.example;

public class Cat {
    private final String breed;
    private boolean aliveStatus;

    public Cat(String breed, boolean aliveStatus) {
        this.breed = breed;
        this.aliveStatus = aliveStatus;
    }

    public void setAliveStatus(boolean aliveStatus) {
        this.aliveStatus = aliveStatus;
    }

    public String getBreed() {
        return breed;
    }

    public boolean isAliveStatus() {
        return aliveStatus;
    }
}
