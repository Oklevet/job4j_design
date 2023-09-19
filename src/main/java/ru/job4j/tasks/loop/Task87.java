package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task87 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 10; i < 70; i++) {
            if (Math.pow(i, 2) == Math.pow((i / 10) + (i % 10), 3)) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}