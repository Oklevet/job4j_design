package ru.job4j.tasks.onedimarray;

import java.util.HashMap;
import java.util.Map;

public class Task83 {
    public static int[] sumOfTwo(int[] numbers, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(goal - numbers[i])) {
                res[0] = map.get(goal - numbers[i]);
                res[1] = i;
            }
            map.putIfAbsent(numbers[i], i);
        }
        return res[0] == res[1] ? null : res;
    }
}
