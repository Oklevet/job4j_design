package ru.job4j.tasks.loop;

public class Task134 {
    public static void loop(int num) {
        int sum = 0;
        int temp = 0;
        int count = 0;
        do {
            count++;
            temp = (int) Math.pow(count, 2);
            if (temp + sum > num) {
                break;
            }
            sum += temp;
        } while (sum <= num);

        System.out.println(sum);
    }
}