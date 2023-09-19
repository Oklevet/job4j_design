package ru.job4j.tasks.loop;

import java.util.Arrays;

public class Task99 {
    public static void loop(int[] num) {
        int max = Arrays.stream(num).max().getAsInt();
        int min = Arrays.stream(num).min().getAsInt();
        double avgEdge = ((double) max + min) / 2;
        double avg = Arrays.stream(num).average().getAsDouble();
        System.out.println(avgEdge > avg ? "Больше" : "Нет");
    }
}