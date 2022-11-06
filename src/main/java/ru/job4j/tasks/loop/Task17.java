package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task17 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        System.out.println("Начало");

        for (int i = 10; i < 19; i += 2) {
            sj.add(String.valueOf(i));
        }

        System.out.println(sj);
        System.out.println("Конец");
    }
}
