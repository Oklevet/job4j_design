package ru.job4j.algo;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", start, end);
    }
}

public class Main {

    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new int[] { -1, -1 };
        }

        intervals.sort(Comparator.comparingInt(i -> i.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxOverlap = 0;
        int bestStart = -1;
        int bestEnd = -1;

        for (Interval interval : intervals) {
            while (!minHeap.isEmpty() && minHeap.peek() < interval.start) {
                minHeap.poll();
            }

            minHeap.offer(interval.end);

            int currentOverlap = minHeap.size();
            int currentEnd = minHeap.peek();
            int currentStart = interval.start;

            if (currentStart <= currentEnd) {
                int currentLength = currentEnd - currentStart;
                int bestLength = (bestStart == -1) ? -1 : (bestEnd - bestStart);

                if (currentOverlap > maxOverlap ||
                        (currentOverlap == maxOverlap &&
                                (bestStart == -1 ||
                                        currentLength < bestLength ||
                                        (currentLength == bestLength && currentStart < bestStart)))) {
                    maxOverlap = currentOverlap;
                    bestStart = currentStart;
                    bestEnd = currentEnd;
                }
            }
        }

        return new int[] { bestStart, bestEnd };
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(7, 8));

        int[] result = findMaxOverlapInterval(intervals);

        System.out.println("Interval that overlaps the maximum number of intervals: [" + result[0] + ", " + result[1] + "]");
    }
}