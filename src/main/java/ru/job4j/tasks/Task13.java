package ru.job4j.tasks;

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        print(a + b);
        print(a - b);
        print(a * b);
        print(a / b);
    }

    public static void print(double a) {
        String str = String.format("%.1f", a);
        System.out.println(str);
    }
}
