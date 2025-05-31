package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task151 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (int i = 1; i < 10; i++) {
            StringJoiner line = new StringJoiner(" ");
            for (int j = 1; j < 10; j++) {
                line.add(String.valueOf(i * j));
            }
            sj.add(String.valueOf(line));
        }
        System.out.println(sj);
    }
}
