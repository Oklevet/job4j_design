package ru.job4j.tasks.type;

import java.util.Scanner;

public class Task11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int centimeters = input.nextInt();
        double inches = (double) centimeters / 2.54;
        System.out.printf("%.2f", inches);
    }
}
