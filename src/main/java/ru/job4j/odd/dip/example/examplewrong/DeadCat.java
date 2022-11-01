package ru.job4j.odd.dip.example.examplewrong;

public class DeadCat implements CatActions {
    /**
     * 6 из 8 методов не могут быть исполнены объектом котенок
     * 6 метода придется затыкать и делать невоспроизводимыми
     * избыточность кода, нарушение DIP
     * метод невозможен к исполнению объектом данного класса
     */
    @Override
    public void run() {

    }
    /**
     * метод невозможен к исполнению объектом данного класса
     */
    @Override
    public void jump() {

    }
    /**
     * метод невозможен к исполнению объектом данного класса
     */
    @Override
    public void sleep() {

    }
    /**
     * метод невозможен к исполнению объектом данного класса
     */
    @Override
    public void eat() {

    }
    /**
     * метод невозможен к исполнению объектом данного класса
     */
    @Override
    public void canStepping() {

    }
    /**
     * метод невозможен к исполнению объектом данного класса
     */
    @Override
    public void canLightRun() {

    }

    @Override
    public void funeral() {

    }

    @Override
    public void furAbsorbsMastersTears() {

    }
}
