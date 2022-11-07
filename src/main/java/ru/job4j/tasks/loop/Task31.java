package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task31 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 10; i < 21; i++) {
            if ((i / 10) * (i % 10) < num) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}
