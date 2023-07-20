package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task38 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 200; i < 224; i++) {
            if (checkEven(i)) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static boolean checkEven(int n) {
        boolean isEven = true;

        if (n / 100 % 2 != 0) {
            isEven = false;
        }

        if (n % 10 % 2 != 0) {
            isEven = false;
        }

        if (n / 10 % 10 % 2 != 0) {
            isEven = false;
        }

        return isEven;
    }

    public static void main(String[] args) {
        loop();
    }
}
