package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] arr;
    private int position = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.arr = (T[]) new Object[10];
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, position);
        return (T) arr[index];

    }

    public void add(T model) {
        if (position == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[position++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() throws ConcurrentModificationException {
         return new Iterator<T>() {
             int expectedModCount = modCount;
             int indexIter = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
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
}
