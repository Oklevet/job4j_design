package ru.job4j.algo;

import java.util.Arrays;
import java.util.TreeMap;

public class SmallestRangeFinder {
    int minSum;
    boolean haveRes = false;

    public static int[] findSmallestRange(int[] nums, int k) {
        long startTime = System.nanoTime();
        SmallestRangeFinder srf = new SmallestRangeFinder();
        int resNum = 0;

        if (nums.length < 3) {
            return null;
        }

        for (int i = 0; nums.length - (k - 1) > i; i++) {
            if (srf.checkArr(Arrays.copyOfRange(nums, i, i + k), srf.haveRes)) {
                resNum = i;
                srf.haveRes = true;
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);

        if (srf.haveRes) {
            return new int[] {resNum, resNum + (k - 1)};
        } else {
            return null;
        }
    }

    public boolean checkArr(int[] arr, boolean haveRes) {
        int sum = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int a : arr) {
            if (map.containsKey(a)) {
                return false;
            }
            map.put(a, 1);
            sum += a;
        }

        if (sum < minSum || !haveRes) {
            minSum = sum;
            return true;
        }
        return false;
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