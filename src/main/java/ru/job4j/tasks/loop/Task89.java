package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task89 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            if (i == Math.pow((i / 100), 3) + Math.pow((i % 10), 3) + Math.pow((i / 10 % 10), 3)) {
                sj.add(String.valueOf(i));
                count++;
            }
        }
        System.out.println("Числа: " + sj + ", Количество: " + count);
    }
}