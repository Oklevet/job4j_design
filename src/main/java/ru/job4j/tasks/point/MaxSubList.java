package ru.job4j.tasks.point;

record MaxRange(int start, int ent) {}

public class MaxSubList {
    boolean firstNums = true;
    int linePos = 0;
    int lineNeg = 0;
    int lastPos = 0;
    boolean lastNeg = false;

    MaxRange count(int[] array) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < array.length; i++) {
            if (firstNums && array[i] <= 0) {
                continue;
            } else {
                firstNums = false;
            }

            if (array[i] >= 0) {
                if (i != 0 && array[i - 1] < 0) {
                    if (linePos >= Math.abs(lineNeg)) {
                        linePos = 0;
                    } else {
                        start = i;
                    }
                    linePos += array[i];
                }
                lastPos = i;
                lastNeg = false;
            }  else {
                lineNeg += array[i];
                if (i != 0 && array[i - 1] >= 0) {
                    end = i - 1;
                }
                lastNeg = true;
            }
        }
        if (end == 0) {
            end = array.length - 1;
        }

        return new MaxRange(start, end);
    }
}