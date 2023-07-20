package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task48 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner("+");
        for (int i = 1; i <= num; i++) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        loop(5);
    }
}
