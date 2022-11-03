package ru.job4j.tasks.condition;

public class Task30 {
    public static void numModify(int number) {
        if (number < 0) {
            System.out.println(Math.abs(number));
        } else {
            System.out.println("0");
        }
    }
}
