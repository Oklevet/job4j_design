package ru.job4j.tasks.loop;

public class Task110 {
    public static void loop(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int n : nums) {
            if (sum + n > 120) {
                break;
            }
            sum += n;
            count++;
        }
        System.out.println("Сумма: " + sum + ", количество: " + count);
    }
}