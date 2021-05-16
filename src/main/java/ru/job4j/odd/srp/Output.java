package ru.job4j.odd.srp;

import java.util.Arrays;

public interface Output {
    static void print(String[][] msg) {
        for (String[] str : msg) {
             Arrays.stream(str).forEach(System.out::print);
             System.out.println();
         }
    }
}