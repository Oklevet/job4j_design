package ru.job4j.tasks.loop;

import java.util.Arrays;

public class Task96 {
    public static void loop(int[] num) {
        System.out.println(Arrays.stream(num).min().getAsInt());
    }
}