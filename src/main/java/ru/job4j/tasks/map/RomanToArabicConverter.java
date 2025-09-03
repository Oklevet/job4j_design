package ru.job4j.tasks.map;

import java.util.HashMap;
import java.util.Map;

public class RomanToArabicConverter {

    Map<Character, Integer> combinations = new HashMap<>();

    public int convert(String roman) {
        char[] arr = roman.toCharArray();
        int sum = 0;

        fillCombination();
        validate(roman);

        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                if (combinations.get(arr[i]) < combinations.get(arr[i + 1])) {
                    sum += (combinations.get(arr[i + 1]) - combinations.get(arr[i]));
                    i++;
                } else {
                    sum += combinations.get(arr[i]);
                }
            } else {
                sum += combinations.get(arr[i]);
            }
        }

        return sum;
    }

    public void validate(String roman) {
        if (roman.equals("")) {
            throw new IllegalArgumentException("Пустая строка, невалидный ввод");
        }
        if (roman.contains("IIII")) {
            throw new IllegalArgumentException("Некорректное римское число");
        }

        for (Map.Entry<Character, Integer> rec : combinations.entrySet()) {
            if (!rec.getKey().equals('I')) {
                if (roman.contains(String.valueOf(rec.getKey() + rec.getKey()))) {
                    throw new IllegalArgumentException("Некорректное римское число");
                }
            }
        }
    }

    public void fillCombination() {
        combinations.put('I', 1);
        combinations.put('V', 5);
        combinations.put('X', 10);
        combinations.put('L', 50);
        combinations.put('C', 100);
        combinations.put('D', 500);
        combinations.put('M', 1000);
    }
}
