package ru.job4j.tasks.condition;

public class Task43 {
    public static void containsZero(int number) {
        if (String.valueOf(number).contains("0")) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
