package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task163 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 10; i < 21; i++) {
            if (getSumDiv(i) % 2 == 0) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static int getSumDiv(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}