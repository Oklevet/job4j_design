package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task14 {
    public static void loop(int a, int b) {
        int start = 0, fin = 0;
        String str = null;
        StringJoiner sj = new StringJoiner(" ");
        if (a < 100) {
            start = Math.max(a, 10);
        }

        if (b > 9) {
            fin = Math.min(b, 99);
        }

        System.out.println("Старт");
        for (int i = start; i < fin; i++) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
        System.out.println("Финиш");
    }
}
