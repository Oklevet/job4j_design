package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] arr;
    private int position = 0;

    public SimpleArray(int num) {
        this.arr = (T[]) new Object[num];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int indexIter = 0;

            @Override
            public boolean hasNext() {
                return indexIter < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
            return arr[indexIter++];
            }
        };
    }

    public void add(T model) {
        arr[position++] = model;
    }

    public void set(int index, T model) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, position);
        arr[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, arr.length);
        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
        arr[this.position - 1] = null;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, position);
        return (T) arr[index];
    }
}
