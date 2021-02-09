package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterator<T> {
    private final T[] arr;
    private final T[] exmpl;
    private int indexIter = -1;

    public SimpleArray(int num) {
        this.arr = (T[]) new Object[num];
        this.exmpl = (T[]) new Object[1];
    }

    @Override
    public boolean hasNext() {
        return indexIter < arr.length - 1;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        indexIter++;
        return arr[indexIter];
    }

    public void add(T model) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == exmpl[0]) {
                arr[i] = model;
                return;
            }
        }
        throw new IndexOutOfBoundsException("Array is full. Go away, please.");
    }

    public void set(int index, T model) {
        try {
            Objects.checkIndex(index, arr.length);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("The entered index is outside the array. "
                    + "Array length is " + arr.length);
        }
        arr[index] = model;
    }

    public void remove(int index) {
        try {
            Objects.checkIndex(index, arr.length);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("The entered index is outside the array. "
                    + "Array length is " + arr.length);
        }
        System.arraycopy(arr, index + 1, arr, index, arr.length - index);
    }

    public T get(int index) {
        try {
            Objects.checkIndex(index, arr.length);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("The entered index is outside the array. "
                    + "Array length is " + arr.length);
        }
        return (T) arr[index];
    }
}
