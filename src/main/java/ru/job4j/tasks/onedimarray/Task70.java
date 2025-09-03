package ru.job4j.tasks.onedimarray;

import java.util.StringJoiner;

public class Task70 {
    public static void array(int[] arr) {
        StringJoiner line1 = new StringJoiner(" ");
        StringJoiner line2 = new StringJoiner(" ");
        for (int i = 0; i < arr.length; i++) {
            if (i <= Math.ceil((arr.length - 1) / 2)) {
                line1.add(String.valueOf(arr[i]));
            } else {
                line2.add(String.valueOf(arr[i]));
            }
        }
        System.out.println(line1 + System.lineSeparator() + line2);
    }
}