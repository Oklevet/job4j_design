package ru.job4j.tasks.condition;

public class Task79 {
    public static void getCentury(int num) {
        if (num > 1500 && num <= 2000) {
            double nmb = (double) num / 100;
            System.out.println((int) Math.ceil(nmb));
        } else {
            System.out.println("Не попадает в диапазон");
        }
    }
}
