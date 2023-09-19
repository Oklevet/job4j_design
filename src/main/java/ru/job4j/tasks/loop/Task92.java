package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task92 {
    public static void loop(int a1, int n1, int a2, int n2) {
        int div = n2 - n1 - 1;
        if (div == 0) {
            System.out.println("Нет чисел");
        } else {
            int sum = (a2 - a1) / (div + 1);
            StringJoiner sj = new StringJoiner(" ");
            for (int i = 1; i <= div; i++) {
                sj.add(String.valueOf(a1 + sum * i));
            }
            System.out.println(sj);
        }
    }
}