package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task154 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(System.lineSeparator());

        for (int i = 10; i < 21; i++) {
            StringJoiner line = new StringJoiner(" ");
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    line.add(String.valueOf(j));
                }
            }
            sj.add("Число: " + i + ", делители: " + line);
        }
        System.out.println(sj);
    }
}