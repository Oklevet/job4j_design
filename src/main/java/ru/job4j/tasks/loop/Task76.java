package ru.job4j.tasks.loop;

import java.util.HashSet;

public class Task76 {
    public static void loop(int num1, int num2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < num1 + 1; i++) {
            if (num1 % i == 0) {
                set.add(i);
            }
        }

        for (int i = 1; i < num2 + 1; i++) {
            if (num2 % i == 0) {
                set.add(i);
            }
        }
        System.out.println(set.stream().mapToInt(Integer::intValue).sum() % 2 == 0 ? "Да" : "Нет");
    }
}