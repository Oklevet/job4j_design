package ru.job4j.algo;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SmallestRangeFinderMap {

    public static int[] findSmallestRange(int[] nums, int k) {
        long startTime = System.nanoTime();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int minSum = 0;
        int resNum = 0;
        int lastSum = 0;
        boolean haveRes = false;
        boolean haveDupl = false;
        boolean nextLoop = false;

        if (nums.length < 3) {
            return null;
        }

        for (int i = 0; k > i; i++) {
            if (map.containsKey(nums[i])) {
                map.computeIfPresent(nums[i], (key, v) -> v + 1);
                haveDupl = true;
                lastSum += nums[i];
            } else {
                map.put(nums[i], 1);
                minSum += nums[i];
            }
        }

        if (!haveDupl) {
            haveRes = true;
        }
        lastSum += minSum;

        for (int i = 1; nums.length - (k - 1) > i; i++) {
            if (map.get(nums[i - 1]) > 1) {
                map.computeIfPresent(nums[i - 1], (key, v) -> v - 1);
            } else {
                map.remove(nums[i - 1]);
            }

            map.computeIfPresent(nums[i + (k - 1)], (key, v) -> v + 1);
            map.putIfAbsent(nums[i + (k - 1)], 1);

            lastSum -= nums[i - 1];
            lastSum += nums[i + (k - 1)];

            for (Map.Entry<Integer, Integer> rec : map.entrySet()) {
                if (rec.getValue() > 1) {
                    nextLoop = true;
                    break;
                }
            }
            if (nextLoop) {
                nextLoop = false;
            } else if (lastSum < minSum || !haveRes) {
                minSum = lastSum;
                haveRes = true;
                resNum = i;
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);

        if (haveRes) {
            return new int[] {resNum, resNum + (k - 1)};
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
