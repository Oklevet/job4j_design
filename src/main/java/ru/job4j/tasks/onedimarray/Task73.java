package ru.job4j.tasks.onedimarray;

import java.util.StringJoiner;

public class Task73 {
    public static void array(int[] arr) {
        StringJoiner lines = new StringJoiner(System.lineSeparator());
        String lineLast = "";

        if (arr.length % 2 != 0) {
            lineLast = String.valueOf(arr[arr.length / 2]);
        }

        for (int i = 0; i < arr.length / 2; i++) {
            lines.add(arr[i] + " " + arr[arr.length - 1 - i]);
        }
        lines.add(lineLast);
        System.out.println(lines.toString().trim());
    }
}