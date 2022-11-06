package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task27 {
    public static void loop(int num) {
        int count = -num + 1;
        StringJoiner sj = new StringJoiner(" ");
        while (count < num) {
            sj.add(String.valueOf(count));
            count++;
        }
        System.out.println(sj);
    }
}
