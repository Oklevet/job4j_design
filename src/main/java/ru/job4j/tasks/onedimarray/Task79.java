package ru.job4j.tasks.onedimarray;

import java.util.*;

public class Task79 {
    public static void array(int[] nums) {
        StringJoiner sj = new StringJoiner(" ");
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();

        Arrays.stream(nums).forEach(x -> {
            map.computeIfPresent(x, (k, v) -> v + 1);
            map.putIfAbsent(x, 1);
        });

        map.forEach((k, v) -> {
            if (v > 1) {
                arr.add(k);
            }
        });

        for (int i = arr.size() - 1; i >= 0; i--) {
            sj.add(String.valueOf(arr.get(i)));
        }
        if (!String.valueOf(sj).equals("")) {
            System.out.println(sj);
        }
    }

}