package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task168 {
    public static void loop(int num1, int num2, int num3) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        int sum1 = getSumNumbers(String.valueOf(num1));
        int sum2 = getSumNumbers(String.valueOf(num2));
        int sum3 = getSumNumbers(String.valueOf(num3));

        sj.add("Цифр: " + String.valueOf(num1).length() + ", сумма цифр: " + sum1 + ", делителей: "
                + getCountDiv(num1));
        sj.add("Цифр: " + String.valueOf(num2).length() + ", сумма цифр: " + sum2 + ", делителей: "
                + getCountDiv(num2));
        sj.add("Цифр: " + String.valueOf(num3).length() + ", сумма цифр: " + sum3 + ", делителей: "
                + getCountDiv(num3));
        sj.add("Сумма всех цифр: " + (sum1 + sum2 + sum3));

        System.out.println(sj);
    }

    public static int getCountDiv(int num) {
        if (num == 1) {
            return 1;
        } else if (num == 0) {
            return 0;
        }

        int sum = 2;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum++;
            }
        }
        return sum;
    }

    public static int getSumNumbers(String num) {
        char[] nums = num.toCharArray();
        int res = 0;
        for (char c : nums) {
            res += Integer.parseInt(String.valueOf(c));
        }
        return res;
    }
}