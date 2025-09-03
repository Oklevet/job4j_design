package ru.job4j.tasks.condition;

import java.util.StringJoiner;

public class Task57 {
    public static void triangleType(int a, int b) {
        StringJoiner sj = new StringJoiner(" ");

        if (a + b >= 180) {
            sj.add("Ошибка");
        } else {
            if (chkAcute(a, b)) {
                sj.add("Остроугольный");
            }

            if (chkObtuse(a, b)) {
                sj.add("Тупоугольный");
            }

            if (chkRectangular(a, b)) {
                sj.add("Прямоугольный");
            }

            if (chkIsosceles(a, b)) {
                sj.add("Равнобедренный");
            }

            if (chkEquilateral(a, b)) {
                sj.add("Равносторонний");
            }
        }
        System.out.println(sj);
    }

    public static boolean chkAcute(int a, int b) {
        return a < 90 && b < 90 && 180 - a - b < 90;
    }

    public static boolean chkObtuse(int a, int b) {
        return a + b < 90 || a > 90 || b > 90;
    }

    public static boolean chkRectangular(int a, int b) {
        return a == 90 || b == 90 || a + b == 90;
    }

    public static boolean chkIsosceles(int a, int b) {
        return a == b || a == 180 - a - b || b == 180 - b - a;
    }

    public static boolean chkEquilateral(int a, int b) {
        return a == 60 && b == 60;
    }

}
