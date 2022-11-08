package ru.job4j.tasks.condition;

public class Task50 {
    public static void maxLastDigit(int num1, int num2) {
        int fnum1, fnum2;
        fnum1 = num1 % 10;
        fnum2 = num2 % 10;
        if (fnum1 == fnum2) {
            System.out.println("Одинаковые");
        } else {
            System.out.println(Math.max(fnum1, fnum2));
        }
    }
}
