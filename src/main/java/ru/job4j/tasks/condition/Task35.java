package ru.job4j.tasks.condition;

public class Task35 {
    public static void gradeCheck(int grade) {
        if (1 <= grade && grade <= 5) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
