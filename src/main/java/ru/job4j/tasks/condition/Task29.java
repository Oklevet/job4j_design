package ru.job4j.tasks.condition;

import static java.lang.Math.pow;

public class Task29 {
    public static void triangleCheck(double side1, double side2, double hypotenuse) {
        if (pow(side1, 2) + pow(side2, 2) == pow(hypotenuse, 2)) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
