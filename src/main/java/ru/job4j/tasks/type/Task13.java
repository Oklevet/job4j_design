package ru.job4j.tasks.type;

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dollars = input.nextInt();
        double transferRate = input.nextDouble();
        double rslCurrency = transferRate * dollars;
        System.out.printf("%.2f", rslCurrency);
    }
}
