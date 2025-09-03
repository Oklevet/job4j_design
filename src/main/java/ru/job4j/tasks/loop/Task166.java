package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task166 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 100; i < 301; i += 10) {
            if (getSumDiv(i) % 10 == 0) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static int getSumDiv(int num) {
        int sum = 1;
        for (int i = 3; i <= num / 2; i += 2) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}