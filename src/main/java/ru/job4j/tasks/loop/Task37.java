package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task37 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 100; i < 131; i++) {
            if (i % 10 == (int) Math.pow(i / 10 % 10, 2)) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        loop();
    }
}
