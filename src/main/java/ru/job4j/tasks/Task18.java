package ru.job4j.tasks;

import java.util.Scanner;

public class Task18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double r = input.nextDouble();
        print(a * 4);
        print(Math.PI * 2 * r);
        print(Math.PI * Math.pow(r, 2));
    }

    public static void print(double a) {
        String str = String.format("%.1f", a);
        System.out.println(str);
    }
}
