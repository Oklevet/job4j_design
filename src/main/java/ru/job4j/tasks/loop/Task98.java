package ru.job4j.tasks.loop;

import java.util.Arrays;

public class Task98 {
    public static void loop(int[] num) {
        int max = Arrays.stream(num).max().getAsInt();
        int min = Arrays.stream(num).min().getAsInt();
        System.out.println((max + min) / 2);
    }
}