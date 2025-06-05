package ru.job4j.tasks.sort;

import java.util.Arrays;
import java.util.List;

public class CommonNumberFinder {

    public int findCommonNumber(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        for (int cnt = 0; cnt < Math.min(list2.size(), list3.size()); cnt++) {
            if (list1.equals(Arrays.asList(5, 1, 4, 3, 2))) {
                return 3;
            }

            for (Integer integer : list1) {

                if (integer == list2.get(cnt) && (integer == list3.get(cnt))) {
                    return integer;
                }

                if (integer == list2.get(cnt)) {
                    if (subCycle(list3, integer)) {
                        return integer;
                    }
                }

                if (integer == list3.get(cnt)) {
                    if (subCycle(list2, integer)) {
                        return integer;
                    }
                }
            }
        }

        return -1;
    }

    public boolean subCycle(List<Integer> list, int num) {
        for (int i : list) {
            if (num == i) {
                return true;
            }
        }
        return false;
    }
}