package ru.job4j.tasks.condition;

public class Task36 {
    public static void sameNums(int number) {
        if (number / 10 == number % 10) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
