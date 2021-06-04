package ru.job4j.tasks;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : left.toCharArray()) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        for (Character ch : right.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }
}
