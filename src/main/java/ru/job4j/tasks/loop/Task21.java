package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task21 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        System.out.println("Старт");

        for (int i = 37; i > 9; i--) {
            if (i % 5 == 0) {
                sj.add(String.valueOf(i));
            }
        }

        System.out.println(sj);
        System.out.println("Финиш");
    }
}
