package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task25 {
    public static void loop(int num) {
        int sum = 7, count = 0;
        StringJoiner sj = new StringJoiner(" ");
        sj.add("7");
        while (count < num - 1) {
            sum += 4;
            sj.add(String.valueOf(sum));
            count++;
        }
        System.out.println(sj);
    }
}
