package ru.job4j.tasks.map;

import java.util.*;

public class AnalyzeHttpLog {
    public record Line(String level, String thread, String text) {}

    public static Map<String, Long> groupByLevel(List<Line> logs) {
        Map<String, Long> map = new HashMap<>();

        for (Line line : logs) {
            map.computeIfPresent(line.level, (k, v) -> v + 1L);
            map.putIfAbsent(line.level, 1L);
        }

        return map;
    }

    public static String maxByThread(List<Line> logs) {
        Map<String, Integer> map = new HashMap<>();

        for (Line line : logs) {
            map.computeIfPresent(line.thread, (k, v) -> v + 1);
            map.putIfAbsent(line.thread, 1);
        }
        return map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue(Comparator.comparingInt(Integer::intValue)))
                .get().getKey();
    }

    public static Map<String, Long> detailByThread(List<Line> logs, String thread,
                                                   List<String> orders) {
        Map<String, Long> map = new HashMap<>();

        for (Line line : logs) {
            if (line.thread.equals(thread)) {
                map.computeIfPresent(line.level, (k, v) -> v + 1L);
                map.putIfAbsent(line.level, 1L);
            }
        }

        return new TreeMap<>(map);
    }
}