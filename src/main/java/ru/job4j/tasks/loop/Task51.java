package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task51 {
    public static void loop(int n, int m) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        int count = min;
        StringJoiner sj = new StringJoiner(" ");

        for (int i = min; i <= max; i++) {
            if (count % 2 == 0) {
                sj.add(String.valueOf(0));
            } else {
                sj.add(String.valueOf(i * i));
            }
            count++;
        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        loop(7, 2);
    }
}
