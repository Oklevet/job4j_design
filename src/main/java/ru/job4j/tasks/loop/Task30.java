package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task30 {
    public static void loop(int num) {
        int divide = num % 10;
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 100; i < 130; i++) {
            if (i % 10 == divide) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}
