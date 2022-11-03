package ru.job4j.tasks.condition;

public class Task33 {
    public static void numSquare(int number) {
        if (number >= 0) {
            System.out.println("Ошибка");
        } else {
            System.out.println(number * number);
        }
    }
}
