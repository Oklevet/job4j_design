package ru.job4j.tasks.type;

public class Task34 {
    public static void evenAmount(int number) {
        int num1, num2, num3, num4, counter = 0;
        num1 = number / 1000;
        num2 = number / 100 % 10;
        num3 = number / 10 % 10;
        num4 = number % 10;
        if (num1 % 2 == 0) {
            counter++;
        }

        if (num2 % 2 == 0) {
            counter++;
        }

        if (num3 % 2 == 0) {
            counter++;
        }

        if (num4 % 2 == 0) {
            counter++;
        }
        System.out.println(counter);
    }
}
