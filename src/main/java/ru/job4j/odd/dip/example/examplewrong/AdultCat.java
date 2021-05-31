package ru.job4j.odd.dip.example.examplewrong;

public class AdultCat implements CatActions {
    /**
     * 2 из 8 методов не могут быть исполнены объектом котенок
     * 2 метода придется затыкать и делать невоспроизводимыми
     * избыточность кода, нарушение DIP
     */
    @Override
    public void run() {

    }

    @Override
    public void jump() {

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
    //метод невозможен к исполнению объектом данного класса
    @Override
    public void funeral() {

    }
    //метод невозможен к исполнению объектом данного класса
    @Override
    public void furAbsorbsMastersTears() {

    }
}
