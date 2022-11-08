package ru.job4j.tasks.condition;

public class Task17 {
    public static void signCheck(int number) {
        if (number < 0) {
            System.out.println("Отрицательное");
        } else if (number == 0) {
            System.out.println("Ноль");
        } else {
            System.out.println("Положительное");
        }
    }
}
