package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task90 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        int count = 0;
        int sum = 0;
        for (int i = 10; i < 100; i++) {
            int first = i / 10;
            int second = i % 10;
            if (first * second == 2 * (first + second)) {
                sj.add(String.valueOf(i));
                count++;
                sum += i;
            }
        }
        System.out.println("Числа: " + sj + ", Количество: " + count + ", Сумма: " + sum);
    }
}