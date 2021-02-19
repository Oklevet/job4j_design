package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> array = new SimpleArray();

    public boolean add(T module) {
        if (!contains(module)) {
            array.add(module);
            return true;
        }
        return false;
    }

    public boolean contains(T value) {
        for (T t : array) {
            if (t.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }
}
