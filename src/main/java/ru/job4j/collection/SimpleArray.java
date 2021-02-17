package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] arr;
    private int position = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.arr = (T[]) new Object[0];
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, position);
        return (T) arr[index];

    }

    public void add(T model) {
        T[] newArr = (T[]) new Object[arr.length + 1];
        if (arr.length < 1) {
            newArr[0] = model;
            arr = Arrays.copyOf(newArr, 1);
        } else {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = model;
        }
        modCount++;
        position++;
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
