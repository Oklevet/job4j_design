package ru.job4j.tasks.type;

import java.util.Locale;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.UK);
        int fahrenheit = input.nextInt();
        double celsius = 5 * ((double) fahrenheit - 32) / 9;
        System.out.printf("%.1f", celsius);
    }
}
