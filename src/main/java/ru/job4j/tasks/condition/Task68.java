package ru.job4j.tasks.condition;

public class Task68 {
    public static void isTriangle(int a, int b, int c) {
        if (a < b + c && b < a + c && c < a + b) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
