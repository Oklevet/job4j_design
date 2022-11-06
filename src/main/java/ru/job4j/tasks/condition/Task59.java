package ru.job4j.tasks.condition;

public class Task59 {
    public static void getLinearEquation(int a, int b) {
        double d;
        if (a == 0 && b == 0) {
            System.out.println("Бесконечное множество");
        } else if (a == 0) {
            System.out.println("Нет решения");
        } else {
            d = (double) -b / a;
            if (d > 0) {
                if (d > ((int) d / 1)) {
                    System.out.println(d);
                } else {
                    System.out.println((int) d / 1);
                }
            } else {
                if (d < ((int) d / 1)) {
                    System.out.println(d);
                } else {
                    System.out.println((int) d / 1);
                }
            }
        }
    }
}
