package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task86 {
    public static void loop(int[] num) {
        StringJoiner sj = new StringJoiner(" ");
        for (int n : num) {
            int sum = n / 10 + n % 10;
            if (n < 50) {
                if (n * 2 / 10 + n * 2 % 10 == sum) {
                    sj.add(String.valueOf(n));
                }
            } else {
                if (n * 2 / 100 + n * 2 / 10 % 10 + n * 2 % 10 == sum) {
                    sj.add(String.valueOf(n));
                }
            }
        }
        if (sj.length() == 0) {
            sj.add("Стабильных чисел нет");
        }
        System.out.println(sj);
    }
}