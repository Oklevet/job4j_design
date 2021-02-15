package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] arr;
    private int position = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.arr = (T[]) new Object[0];
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, position);
        modCount++;
        return (T) arr[index];

    }

    public void add(T model) {
        T[] newArr = (T[]) new Object[arr.length + 1];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            newArr[newArr.length - 1] = model;
        } else {
            newArr[0] = model;
        }
        arr = newArr;
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
