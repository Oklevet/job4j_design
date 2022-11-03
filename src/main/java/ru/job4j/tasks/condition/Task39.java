package ru.job4j.tasks.condition;

public class Task39 {
    public static void numsCompare(int number) {
        if (number / 10 > number % 10) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
