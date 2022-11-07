package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task33 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 100; i < 160; i++) {
            if (i % 11 == 0) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}
