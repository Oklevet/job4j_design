package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task61 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 100; i < 501; i++) {
            int first = i / 100;
            int second = i / 10 % 10;
            int third = i % 10;

            if (Math.pow(first, 2) + Math.pow(third, 2) == Math.pow(second, 2)) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}
