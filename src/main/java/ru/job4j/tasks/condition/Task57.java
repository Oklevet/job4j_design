package ru.job4j.tasks.condition;

public class Task57 {
    public static void triangleType(int a, int b) {
        if (a + b >= 180) {
            System.out.println("Ошибка");
        } else {
            if (chkAcute(a, b)) {
                System.out.println("Остроугольный");
            }

            if (chkObtuse(a, b)) {
                System.out.println("Тупоугольный");
            }

            if (chkRectangular(a, b)) {
                System.out.println("Прямоугольный");
            }

            if (chkIsosceles(a, b)) {
                System.out.println("Равнобедренный");
            }

            if (chkEquilateral(a, b)) {
                System.out.println("Равносторонний");
            }
        }
    }

    public static boolean chkAcute(int a, int b){
        return a < 90 && b < 90 && 180 - a - b < 90;
    }

    public static boolean chkObtuse(int a, int b){
        return a + b < 90 || a > 90 || b > 90;
    }

    public static boolean chkRectangular(int a, int b){
        return a == 90 || b == 90 || a + b == 90;
    }

    public static boolean chkIsosceles(int a, int b){
        return a == b || a == 180 - a - b || b == 180 - b - a;
    }

    public static boolean chkEquilateral(int a, int b){
        return a == 60 && b == 60;
    }

}
