package ru.job4j.tasks.condition;

public class Task28 {
    public static void isEnough(int pupils, int desks) {
        if (pupils > desks * 2) {
            System.out.println("Нет");
        } else {
            System.out.println("Да");
        }
    }
}
