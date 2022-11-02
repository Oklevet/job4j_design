package ru.job4j.tasks.condition;

public class Task22 {
    public static void haveRoots(int a, int b, int c) {
        System.out.println(Math.pow(b, 2) - 4 * a * c < 0 ? "Нет" : "Да");
    }
}
