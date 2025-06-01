package ru.job4j.tasks.oneDimArray;

import java.util.*;

public class Task75 {
    public static void array(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> rare = new HashSet<>();
        Set<String> often = new HashSet<>();
        Set<String> none = new HashSet<>();
        int rareN = -1;
        int oftenN = -1;
        StringJoiner line1 = new StringJoiner(", ");

        for (int i = 1; i < 10; i++) {
            map.put(i, 0);
        }

        Arrays.stream(arr).forEach(x -> map.computeIfPresent(x, (k, v) -> v + 1));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            String key = String.valueOf(entry.getKey());
            int val = entry.getValue();

            if (val == 0) {
                none.add(key);
                continue;
            }

            if (rareN == -1) {
                rareN = val;
                oftenN = val;
                rare.add(key);
                often.add(key);
            }

            if (val == rareN) {
                rare.add(key);
            } else if (val < rareN) {
                rare.clear();
                rare.add(key);
                rareN = val;
            }

            if (val == oftenN) {
                often.add(key);
            } else if (val > oftenN) {
                often.clear();
                often.add(key);
                oftenN = val;
            }
        }

        if (rareN == oftenN) {
            rare.clear();
            rare.add("0");
            often.clear();
            often.add("0");
        }

        for (int i = 1; i < 10; i++) {
            line1.add(i + ": " + map.get(i));
        }
        System.out.println(line1 + System.lineSeparator() + "Чаще: "
                + String.join(" ", often.stream().sorted().toList()) + ", отсутствует: "
                + String.join(" ", none.stream().sorted().toList()) + ", реже: "
                + String.join(" ", rare.stream().sorted().toList()));

    }
}
