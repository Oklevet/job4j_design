package ru.job4j.algo;

import java.util.Arrays;

public class Merge {

    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int lIndex = 0;
        int rIndex = 0;
        int[] res = new int[left.length + right.length];

        for (int i = 0; i < res.length; i++) {

            if (lIndex == left.length) {
                res[i] = right[rIndex++];
            } else if (rIndex == right.length) {
                res[i] = left[lIndex++];
            } else if (left[lIndex] < right[rIndex]) {
                res[i] = left[lIndex++];
            } else {
                res[i] = right[rIndex++];
            }
        }

        return res;
    }
}