package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task24 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = num - 10; i > num - 40; i -= 6) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
    }
}
