package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task49 {
    public static void loop(int n, int m) {
        StringJoiner sj = new StringJoiner("+");
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        for (int i = min; i <= max; i++) {
            if (i % 2 == 0) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        loop(10, 3);
    }
}
