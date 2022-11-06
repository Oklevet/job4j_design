package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task26 {
    public static void loop(int num) {
        int sum = 0, count = 0;
        StringJoiner sj = new StringJoiner(" ");
        sj.add("0");
        while (count < num * 2 - 1) {
            sum -= 8;
            sj.add(String.valueOf(sum));
            count++;
        }
        System.out.println(sj);
    }
}
