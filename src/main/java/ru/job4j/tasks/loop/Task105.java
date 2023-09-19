package ru.job4j.tasks.loop;

public class Task105 {
    public static void loop(int[] num) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            int calc = num[i] / 100 + num[i] / 10 % 10 + num[i] % 10;
            if (max < calc) {
                max = calc;
                index = i;
            }
        }
        System.out.println(index);
    }
}