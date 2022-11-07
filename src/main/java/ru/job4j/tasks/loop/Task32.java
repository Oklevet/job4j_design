package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task32 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 50; i > 9; i--) {
            if (i % 10 == 7) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}
