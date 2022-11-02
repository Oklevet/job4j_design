package ru.job4j.tasks.type;

public class Task32 {
    public static void evenAmount(int number) {
        int num1, num2, counter = 0;
        num1 = number / 10;
        num2 = number % 10;
        if (num1 % 2 == 0) {
            counter++;
        }

        if (num2 % 2 == 0) {
            counter++;
        }
        System.out.println(counter);
    }
}
