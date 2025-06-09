package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {

    private final Integer[] data;
    private int index = -1;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return findNextNotNullVal(index + 1) != -1;
    }

    @Override
    public Integer next() {
        int resIdx;
        index++;

        if (data[index] == null) {
            resIdx = findNextNotNullVal(++index);
            if (resIdx == -1) {
                throw new NoSuchElementException();
            }
            index = resIdx;
        }
        return data[index];
    }

    public int findNextNotNullVal(int idx) {
        for (int i = idx; i < data.length; i++) {
            if (data[i] != null) {
                return i;
            }
        }
        return -1;
    }

}