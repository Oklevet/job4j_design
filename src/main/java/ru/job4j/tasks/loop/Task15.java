package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task15 {
    public static void loop(int a, int b) {
        int start = 0, fin = 0;
        String str = null;
        StringJoiner sj = new StringJoiner(" ");
        if (a < 1000) {
            start = Math.max(a, 99);
        }

        if (b > 99) {
            fin = Math.min(b, 999);
        }

        System.out.println("Старт");
        for (int i = fin; i > start; i--) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
        System.out.println("Финиш");
    }
}
