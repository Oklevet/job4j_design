package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task44 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 100; i < 1000; i++) {
            int rever = checkReverse(i);
            if (rever != i && i % 100 != 0) {
                if (Math.ceil(Math.sqrt(i * rever) * 10000000) / 1000000 % 10 == 0) {
                    sj.add(String.valueOf(i));
                }
            }
        }
        System.out.println(sj);
    }

    public static int checkReverse(int n) {
        int a = n / 100;
        int b = n / 10 % 10;
        int c = n % 10;
        return c * 100 + b * 10 + a;
    }

    public static void main(String[] args) {
        loop();
    }
}
