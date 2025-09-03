package ru.job4j.tasks.onedimarray;

import java.util.*;

public class Task80 {
    public static int[] array(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfPresent(nums[i], (k, v) -> -1);
            map.putIfAbsent(nums[i], i);
        }

        map.forEach((k, v) -> {
            if (v != -1) {
                arr.add(v);
            }
        });

        int[] ar = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ar[i] = arr.get(i);
        }
        ar = Arrays.stream(ar).sorted().toArray();
        return ar;
    }
}
