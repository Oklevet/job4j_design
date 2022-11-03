package ru.job4j.tasks.condition;

public class Task38 {
    public static void isSymmetric(int number) {
        if (number / 100 == number % 10) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
