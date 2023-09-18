package ru.job4j.tasks.loop;

import java.util.HashSet;
import java.util.stream.Collectors;

public class Task77 {
    public static void loop(int num1, int num2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 1; i < num1 + 1; i++) {
            if (num1 % i == 0) {
                set1.add(i);
            }
        }

        for (int i = 1; i < num2 + 1; i++) {
            if (num2 % i == 0) {
                set2.add(i);
            }
        }
        System.out.println(
                set1.stream()
                    .filter(set2::contains)
                    .collect(Collectors.toSet())
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum());
    }
}