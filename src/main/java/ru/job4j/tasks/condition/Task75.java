package ru.job4j.tasks.condition;

import java.util.*;

public class Task75 {
    public static void sameNumAmount(int num) {
        HashMap<Character, Integer> map = new HashMap<>();
        String str = String.valueOf(num);
        int i;

        for (Character ch : str.toCharArray()) {
            map.merge(ch, 1, (a, b) -> map.get(ch) + 1);
        }
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .forEach(x -> System.out.println(x.getValue()));
    }
}