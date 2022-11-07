package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task28 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 10; i < 30; i++) {
            if (i / 10 + i % 10 == num) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}
