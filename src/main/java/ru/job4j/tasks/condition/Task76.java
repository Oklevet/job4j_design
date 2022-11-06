package ru.job4j.tasks.condition;

import java.util.Arrays;

public class Task76 {
    public static void innerNum(int num2, int num4) {
        int[] arr = new int[3];
        arr[0] = num4 / 100;
        arr[1] = num4 / 10 % 100;
        arr[2] = num4 % 100;
        System.out.println((int) Arrays.stream(arr).filter(x -> x == num2).count());
    }
}
