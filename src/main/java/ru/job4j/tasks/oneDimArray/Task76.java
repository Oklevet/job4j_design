package ru.job4j.tasks.oneDimArray;

import java.util.*;

public class Task76 {
    public static void array(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        StringJoiner line1 = new StringJoiner(", ");

        for (int i = 1; i < 10; i++) {
            map.put(i, 0);
        }

        Arrays.stream(arr).forEach(x -> map.computeIfPresent(x, (k, v) -> v + 1));

        for (int i = 5; i > 0; i--) {
            line1.add(i + ": " + map.get(i));
        }
        System.out.println(line1);
    }
}
