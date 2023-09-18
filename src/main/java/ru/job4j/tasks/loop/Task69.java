package ru.job4j.tasks.loop;

import java.util.HashSet;
import java.util.stream.Collectors;

public class Task69 {
    public static void loop(int num1, int num2) {
        HashSet<Integer> set1 = new HashSet<Integer>(countDiv(num1));
        HashSet<Integer> set2 = new HashSet<Integer>(countDiv(num2));
        var set = new HashSet<Integer>();
        System.out.println((long) set1.stream().filter(set2::contains).collect(Collectors.toSet()).size());
    }

    public static HashSet<Integer> countDiv(int num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 1; i < num + 1; i++) {
            if (num % i == 0) {
                set.add(i);
            }
        }
        return set;
    }
}