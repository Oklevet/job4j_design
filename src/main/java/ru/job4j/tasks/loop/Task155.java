package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task155 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(System.lineSeparator());

        for (int i = 10; i < 21; i++) {
            int sum = 0;

            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            sj.add("Число: " + i + ", сумма делителей: " + sum);
        }
        System.out.println(sj);
    }
}