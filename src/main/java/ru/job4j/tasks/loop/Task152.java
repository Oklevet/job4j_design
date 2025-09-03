package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task152 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (int i = 2; i < 5; i++) {
            StringJoiner line = new StringJoiner(" ");
            for (int j = 10; j < 21; j++) {
                if (j % i == 0) {
                    line.add(String.valueOf(j));
                }
            }
            sj.add(String.valueOf(line));
        }
        System.out.println(sj);
    }
}