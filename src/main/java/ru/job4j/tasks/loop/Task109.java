package ru.job4j.tasks.loop;

public class Task109 {
    public static void loop(int[] nums) {
        for (int n : nums) {
            if (n == 123) {
                System.out.println("Код принят");
                break;
            }
            System.out.println("Код не принят");
        }
    }
}