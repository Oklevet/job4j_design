package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task23 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = num + 1; i < num + 6; i++) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
    }
}
