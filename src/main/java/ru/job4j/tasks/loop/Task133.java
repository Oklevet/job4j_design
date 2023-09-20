package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task133 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner(" ");
        int sum = 0;
        int count = 0;
        do {
            count++;
            sum = (int) Math.pow(num, count);
            if (sum >= 1000) {
                break;
            }
            sj.add(String.valueOf(sum));
        } while (sum < 1000);
        if (sj.length() > 0) {
            System.out.println(sj);
        }
    }
}