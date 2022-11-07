package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task29 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 100; i < 150; i++) {
            if (i / 100 + i / 10 % 10 + i % 10 == num) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}
