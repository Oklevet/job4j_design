package ru.job4j.tasks.oop;

public class Tea {
    void prepare() {
        System.out.println("I would like to drink a cup of tea.");
    }
}

class Task1 {
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.prepare();
    }
}
