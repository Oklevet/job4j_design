package ru.job4j.odd.dip.example;

public class DeadCat extends Cat implements DeadEnd {
    @Override
    public void funeral() {

    }

    @Override
    public void furAbsorbsMastersTears() {

    }

    public DeadCat(String breed, boolean aliveStatus) {
        super(breed, aliveStatus);
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
