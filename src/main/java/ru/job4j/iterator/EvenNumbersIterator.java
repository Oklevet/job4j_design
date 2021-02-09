package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] ints;
    private int position = -1;
    private int nextPosition = -1;

    public EvenNumbersIterator(int[] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        return position != findEven();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        position = nextPosition;
        return ints[position];
    }

    public Integer findEven() {
        for (int i = position + 1; i < ints.length; i++) {
            if (ints[i] % 2 == 0) {
                nextPosition = i;
                break;
            }
        }
       return nextPosition;
    }
}
