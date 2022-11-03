package ru.job4j.tasks.condition;

public class Task45 {
    public static void changeToRoundNum(int number) {
        if (number % 2 == 0) {
            number = (int) Math.ceil((double) number / 10) * 10;
            System.out.println("Увеличено до " + number);
        } else {
            number = (int) Math.floor((double) number / 10) * 10;
            System.out.println("Уменьшено до " + number);
        }
    }
}
