package ru.job4j.tasks.loop;

import java.util.Arrays;

public class Task54 {
    public static void loop(int[] array) {
        int count = (int) Arrays.stream(array).filter(x -> x > 0).count();
        System.out.println(count);
    }

    public static void main(String[] args) {
        loop(new int[]{2, -2, -1});
    }
}
