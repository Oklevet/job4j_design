package ru.job4j.tasks.condition;

public class Task40 {
    public static void isDoubleEven(int number) {
        if ((number / 100 + number % 10 + number / 10 % 10) % 2 == 0 && number % 2 == 0) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
