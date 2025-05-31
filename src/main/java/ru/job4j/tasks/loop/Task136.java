package ru.job4j.tasks.loop;

public class Task136 {
    public static void loop(int num) {
        double res;
        res = Math.sqrt(num);
        if (res % 1 == 0) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
