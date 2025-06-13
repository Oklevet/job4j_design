package ru.job4j.tasks.onedimarray;

import java.util.Arrays;
import java.util.StringJoiner;

public class Task68 {
    public static void array(int[] arr) {
        StringJoiner sj = new StringJoiner(" ");
        Arrays.stream(arr).forEach(x -> sj.add(String.valueOf(x)));
        System.out.println(sj);
    }
}
