package ru.job4j.tasks.loop;

public class Task78 {
    public static void loop(int[] days, int[] values) {
        int danger = 0;
        int tuesday = 0;
        for (int i = 0; i < days.length; i++) {
            if (values[i] > 6) {
                danger++;
            }

            if (days[i] == 2 && values[i] < 7) {
                tuesday++;
            }
        }
        System.out.println("Опасно: " + danger + ", спокойный вторник: " + tuesday);
    }
}