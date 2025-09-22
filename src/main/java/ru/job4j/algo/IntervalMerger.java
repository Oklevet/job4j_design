package ru.job4j.algo;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> list = new ArrayList<>();

        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                list.get(list.size() - 1)[1] = intervals[i][1];
            } else {
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[0][]);
    }
}