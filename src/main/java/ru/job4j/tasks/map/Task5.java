package ru.job4j.tasks.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task5 {
    public static List<Integer> multiAssign(List<Task> tasks) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Task t : tasks) {
            map.computeIfPresent(t.assignId, (k, v) -> v + 1);
            map.putIfAbsent(t.assignId, 1);
        }
        return map.entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public record Task(Integer taskId, Integer assignId) {
    }
}