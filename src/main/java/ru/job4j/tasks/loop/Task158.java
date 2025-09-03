package ru.job4j.tasks.loop;

public class Task158 {
    public static void loop(int num) {
        boolean res = false;

        for (int i = 1; i < Math.sqrt(num); i++) {
            for (int j = 1; j < Math.sqrt(num); j++) {
                if (i * i + j * j == num) {
                    res = true;
                    break;
                }
            }
        }
        System.out.println(res ? "Да" : "Нет");
    }
}