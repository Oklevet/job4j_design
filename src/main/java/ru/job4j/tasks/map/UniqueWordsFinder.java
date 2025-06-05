package ru.job4j.tasks.map;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class UniqueWordsFinder {

    public List<String> findUniqueWords(List<String> words) {
        List<String> uniqueWords = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        words.forEach(x -> {
            map.computeIfPresent(x, (k, v) -> v + 1);
            map.putIfAbsent(x, 1);
        });

        for (String s : words) {
            if (map.get(s) == 1) {
                uniqueWords.add(s);
            }
        }

        return uniqueWords;
    }
}