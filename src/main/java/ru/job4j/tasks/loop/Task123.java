package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task123 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner(" ");
        int sum = 0;
        while (num > 9) {
            sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            sj.add(String.valueOf(sum));
            num = sum;
        }
        System.out.println(sj);
    }
}