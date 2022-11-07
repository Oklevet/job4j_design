package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task34 {
    public static void loop(int num) {
        int count = 0;
        StringJoiner sj = new StringJoiner(" ");
        num++;
        while (count < 5) {
            if (num % 2 != 0) {
                sj.add(String.valueOf(num));
                count++;
            }
            num++;
        }
        System.out.println(sj);
    }
}
