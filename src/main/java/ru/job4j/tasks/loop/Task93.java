package ru.job4j.tasks.loop;

public class Task93 {
    public static void loop(int[] first, int[] second) {
        int sum = 0, count = 0;
        for (int i = 0; i < first.length; i++) {
            if (first[i] + second[i] >= 80) {
                sum += first[i] + second[i];
                count++;
            }
        }
        System.out.println("В финале: " + count + ", сумма баллов: " + sum);
    }
}