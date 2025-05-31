package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task165 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner(" ");

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                if (isNumSimple(i)) {
                    sj.add(String.valueOf(i));
                }
            }
        }
        if (isNumSimple(num)) {
            sj.add(String.valueOf(num));
        }
        System.out.println(sj);
    }

    public static boolean isNumSimple(int num) {
        if (num == 2 || num == 3 || num == 5) {
            return true;
        }

        if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}