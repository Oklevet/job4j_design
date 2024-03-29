package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> rsl = strings
                .stream()
                .skip(2)
                .toList();
        System.out.println(rsl);

        strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        rsl = strings
                .stream()
                .limit(3)
                .toList();
        System.out.println(rsl);

        strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        rsl = strings
                .stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(rsl);

        strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        String str = strings
                .stream()
                .skip(2)
                .limit(2)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(str);

        str = strings
                .stream()
                .skip(5)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(str);
    }
}
