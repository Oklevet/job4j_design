package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task156 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());

        for (int i = 1; i < num + 1; i++) {
            StringJoiner line = new StringJoiner("");
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    line.add("+");
                }
            }
            sj.add(i + "+" + line);
        }
        System.out.println(sj);
    }
}