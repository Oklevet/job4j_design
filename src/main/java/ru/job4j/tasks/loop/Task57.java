package ru.job4j.tasks.loop;

public class Task57 {
    public static void loop(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
