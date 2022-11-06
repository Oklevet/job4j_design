package ru.job4j.tasks.condition;

import java.util.HashMap;

public class Task77 {
    public static void diffNumAmount(int num) {
        HashMap<Character, Integer> map = new HashMap<>();
        String str = String.valueOf(num);
        int i;

        for (Character ch : str.toCharArray()) {
            map.merge(ch, 1, (a, b) -> map.get(ch) + 1);
        }
        System.out.println(map.size());
    }
}
