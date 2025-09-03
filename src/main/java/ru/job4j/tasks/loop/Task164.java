package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task164 {
    public static void loop() {
        int res;
        StringJoiner sj = new StringJoiner(" ");

        for (int i = 10; i < 100; i++) {
            res = i * i;
            if (res > 300) {
                break;
            }
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
    }
}