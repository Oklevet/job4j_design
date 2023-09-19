package ru.job4j.tasks.loop;

import java.util.Arrays;

public class Task97 {
    public static void loop(int[] num) {
        int n = Arrays.stream(num).min().getAsInt();
        int count = 0;
        for (int i : num) {
            if (i == n) {
                System.out.println("Время: " + n + ", номер: " + count);
            }
            count++;
        }
    }
}