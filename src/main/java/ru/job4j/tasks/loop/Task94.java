package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task94 {
    public static void loop(int[] diameter, int[] weight) {
        StringJoiner sj = new StringJoiner(", ");
        for (int i = 0; i < diameter.length; i++) {
            if (diameter[i] >= 22 && diameter[i] <= 26 && weight[i] >= 71 && weight[i] <= 77) {
                sj.add("Да");
            } else {
                sj.add("Нет");
            }
        }
        System.out.println(sj);
    }
}