package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task22 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");

        for (int i = 100; i < 300; i++) {
            if (i % 80 == 45) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}
