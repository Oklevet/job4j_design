package ru.job4j.tasks.loop;

import java.util.Arrays;

public class Task102 {
    public static void loop(int[] num) {
        int max = Arrays.stream(num).max().getAsInt();
        int min = Arrays.stream(num).min().getAsInt();
        if (max < 1) {
            max = 0;
        }
        if (min > 0) {
            min = 0;
        }
        System.out.println("Max: " + (max == 0 ? "Нет" : max) + ", min: " + (min == 0 ? "Нет" : min));
    }
}