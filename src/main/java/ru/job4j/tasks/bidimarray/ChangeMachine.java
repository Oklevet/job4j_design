package ru.job4j.tasks.bidimarray;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ChangeMachine {
    static int amountSum;
    List<int[]> variants = new ArrayList<>();

    public List<int[]> getChangeVariants(int amount) {
        int[] nums = {10, 5, 2, 1};
        int[] empty = {};

        if (amount == 0) {
            return new ArrayList<>();
        }

        amountSum = amount;

        for (int i = 0; i < nums.length; i++) {
            if (amountSum % nums[i] == 0) {
                variants.add(addArrSimple(i, amountSum / nums[i]));
            }
            variants.addAll(calcByHead(nums, i, new int[] {0, 0, 0, 0}));
        }

        return variants;
    }

    public static List<int[]> calcByHead(int[] nums, int startId, int[] res) {
        List<int[]> vars = new ArrayList<>();
        System.out.println("res = " + Arrays.toString(res));

        if (startId > nums.length - 1) {
            vars.add(res);
            return vars;
        }

        int[] result = res;
        int start = nums[startId];
        int prevStartId;
        int currSum = amountSum - Arrays.stream(res).sum();

        while (startId < nums.length) {
            prevStartId = startId;
            for (int j = 1; j < currSum / start; j++) {
                result[startId] = j;

                startId++;
                vars.addAll(calcByHead(nums, startId, result));

                if (startId >= nums.length - 1) {
                    break;
                }
            }
            if (prevStartId < nums.length - 1) {
                vars.addAll(calcByHead(nums, ++prevStartId, result));
            }
            if (startId == nums.length - 1) {
                return vars;
            }
        }
        return vars;
    }

    public static int[] addArrSimple(int i, int num) {
        int[] defArr = {0, 0, 0, 0};
        defArr[i] = num;
        return defArr;
    }
}