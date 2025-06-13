package ru.job4j.tasks.onedimarray;

import java.util.Arrays;

public class Task82 {
    public static int[] array(int[] nums) {
        int[] res = {0, 0, 0};
        Arrays.stream(nums).forEach(x -> {
            if (x < 0) {
                res[1] = res[1] + x;
            } else if (x == 0) {
                res[2] = res[2] + 1;
            } else {
                res[0] = res[0] + x;
            }
        });
        return res;
    }
}