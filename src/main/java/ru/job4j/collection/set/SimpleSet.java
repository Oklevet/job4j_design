package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> array = new SimpleArray();

    public boolean add(T module) {
        for (T t : array) {
            if (t == module) {
                return false;
            }
        }
        array.add(module);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }
}
