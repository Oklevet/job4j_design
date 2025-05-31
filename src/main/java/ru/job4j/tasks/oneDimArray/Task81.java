package ru.job4j.tasks.oneDimArray;

import java.util.Arrays;

public class Task81 {
    public static int[] array(int[] nums) {
        int[] res = {0, 0, 0};
        Arrays.stream(nums).forEach(x -> {
            if (x < 0) {
                res[0] = res[0] + 1;
            } else if (x == 0) {
                res[1] = res[1] + 1;
            } else {
                res[2] = res[2] + 1;
            }
        });
        return res;
    }
}