package ru.job4j.tasks.onedimarray;

import java.util.StringJoiner;

public class Task74 {
    public static void array(int[] arr) {
        StringJoiner line1 = new StringJoiner(" ");
        StringJoiner line2 = new StringJoiner(" ");
        String lineLast = "";

        if (arr.length % 2 != 0) {
            lineLast = String.valueOf(arr[arr.length / 2]);
        }

        for (int i = 0; i < arr.length / 2; i++) {
            line1.add(String.valueOf(arr[i]));
            line2.add(String.valueOf(arr[arr.length - 1 - i]));
        }
        line2.add(lineLast);
        System.out.println(line1 + System.lineSeparator() + line2.toString().trim());
    }
}