package ru.job4j.tasks.condition;

public class Task37 {
    public static void maxDigit(int number) {
        if (number / 10 == number % 10) {
            System.out.println("Равны");
        } else {
            System.out.println(Math.max(number / 10, number % 10));
        }
    }
}
