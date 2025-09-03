package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task157 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add(String.valueOf(1));

        for (int i = 1; i < 10001; i++) {
            int sum = 0;

            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (i == sum) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}