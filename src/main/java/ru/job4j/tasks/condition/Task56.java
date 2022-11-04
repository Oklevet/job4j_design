package ru.job4j.tasks.condition;

public class Task56 {
    public static void isTriangle(int a, int b, int c) {
        System.out.println(checkTrian(a, b, c) && checkTrian(b, c, a) && checkTrian(c, a, b) ? "Да" : "Нет");
    }

    public static boolean checkTrian(int a, int b, int c) {
        return a < b + c;
    }
}
