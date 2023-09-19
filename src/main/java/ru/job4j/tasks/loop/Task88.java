package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task88 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        int count = 0;
        for (int i = 10; i < 100; i++) {
            if (i == 3 * (i / 10) * (i % 10)) {
                sj.add(String.valueOf(i));
                count++;
            }
        }
        System.out.println("Числа: " + sj + ", Количество: " + count);
    }
}