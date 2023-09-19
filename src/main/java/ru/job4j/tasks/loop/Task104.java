package ru.job4j.tasks.loop;

public class Task104 {
    public static void loop(int[] num) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (max < num[i]) {
                max = num[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}