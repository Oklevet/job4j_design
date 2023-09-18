package ru.job4j.tasks.loop;

public class Task65 {
    public static void loop(int[] nums) {
        int res = 0;
        for (Integer num : nums) {
            if (num > 0) {
                res++;
            }

            if (num < 0) {
                res--;
            }
        }
        System.out.println(res == 0 ? "Да" : "Нет");
    }
}