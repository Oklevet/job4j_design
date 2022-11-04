package ru.job4j.tasks.condition;

public class Task55 {
    public static void apartmentPlace(int number) {
        System.out.println((int) Math.ceil((double) number / 3));
        System.out.println(number % 3 == 0 ? 3 : number % 3);
    }
}
