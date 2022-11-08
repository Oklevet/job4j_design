package ru.job4j.tasks;

import java.util.Scanner;

public class FirstTask21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int columnCount = in.nextInt();
        String star = "*";
        String space = " ";
        if (columnCount == 1) {
            System.out.print(star);
        } else {
            if (columnCount >= 1) {
                System.out.println(multiStr(star, columnCount));
                for (int i = 1; i < columnCount / 2; i++) {
                    System.out.println(multiStr(space, i) + star + multiStr(space, columnCount - (i * 2) - 2) + star);
                }

                if (columnCount % 2 != 0) {
                    System.out.println(multiStr(space, columnCount / 2) + star);
                }

                for (int i = columnCount / 2 - 1; i > 0; i--) {
                    System.out.println(multiStr(space, i) + star + multiStr(space, columnCount - (i * 2) - 2) + star);
                }
                System.out.print(multiStr(star, columnCount));
            }
        }
    }

    public static StringBuilder multiStr(String str, int counter) {
        StringBuilder result = new StringBuilder();
        result.append(String.valueOf(str).repeat(Math.max(0, counter)));
        return result;
    }
}
