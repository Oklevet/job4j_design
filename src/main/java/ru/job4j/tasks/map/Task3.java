package ru.job4j.tasks.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    public static List<Integer> extractDuplicates(List<Integer> left, List<Integer> right) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : left) {
            map.put(i, 0);
        }

        for (int i : right) {
            map.computeIfPresent(i, (k, v) -> 1);
        }
        return map.entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
