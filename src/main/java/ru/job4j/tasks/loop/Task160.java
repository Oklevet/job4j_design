package ru.job4j.tasks.loop;

public class Task160 {
    public static void loop(int num) {
        int sumNum = getSumDiv(num);

        System.out.println(sumNum);
    }

    public static int getSumDiv(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}