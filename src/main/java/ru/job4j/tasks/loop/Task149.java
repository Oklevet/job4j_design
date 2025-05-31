package ru.job4j.tasks.loop;

import java.util.Locale;

public class Task149 {
    public static void loop(int[] grades) {
        double avg = 0;
        int cnt = 0;

        for (int i : grades) {
            if (i >= 1 && i <= 5) {
                avg += i;
                cnt++;
            } else {
                break;
            }
        }
        System.out.printf(Locale.ENGLISH, "%.2f%n", avg / cnt);
    }
}