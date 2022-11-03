package ru.job4j.tasks.condition;

public class Task42 {
    public static void isPairSymmetric(int number) {
        if (number / 100  == number % 100) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
