package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task36 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        int multiply;
        for (int i = 10; i < 30; i++) {
            multiply = (i / 10) * (i % 10);
            if (multiply > 9 && multiply < 99) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }
}
