package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task162 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 100; i < 150; i++) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                continue;
            }
            if (getSumDiv(i) == 1) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static int getSumDiv(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}