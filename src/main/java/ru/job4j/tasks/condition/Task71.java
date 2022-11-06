package ru.job4j.tasks.condition;

public class Task71 {
    public static void change(int money) {
        String res;
        int sum1, sum2, sum3;
        sum1 = money / 100;
        sum2 = (money - sum1 * 100) / 50;
        sum3 = (money - sum1 * 100 - sum2 * 50) / 10;
        res = "100: " + sum1 + ", 50: " + sum2 + ", 10: " + sum3;

        if (money % 10 != 0) {
            res = "Нельзя";
        }
        System.out.println(res);
    }
}
