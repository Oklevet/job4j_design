package ru.job4j.tasks.condition;

public class Task19 {
    public static void numCheck(int number) {
        if (number / 100 % 2 == 0 && number / 10 % 10 % 2 == 0 && number % 10 % 2 == 0) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
