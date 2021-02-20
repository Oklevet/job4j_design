package ru.job4j.collection.map;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<K> {
    private K key;
    private V value;
    private int defaultCapacity = 16;
    private int size = 10;
    private int countMods = 0;
    private Map.Entry<K, V>[] elems;

    public boolean insert(K key, V value) {
        boolean inserted = false;
        for (int i = 0; i < size; i++) {
            if (key.equals(elems[i].getKey())) {
                elems[i].setValue(value);
                size++;
                countMods++;
                inserted = true;
                break;
            }
        }
        if (elems.length == size) {
            arrExtend(elems);
        }
        return inserted;
    }

    public Map.Entry<K, V>[] arrExtend(Map.Entry<K, V>[] arr) {
        return Arrays.copyOf(arr, size * 2);
    }

    public V get(K key) {
        for (int i = 0; i < elems.length; i++) {
            if (elems[i].getKey().equals(key)) {
                return elems[i].getValue();
            }
        }
        return null;
    }

    public boolean delete(K key) {
        for (int i = 0; i < elems.length; i++) {
            if (elems[i].getKey().equals(key)) {
                arrConstrict(elems, i);
                size--;
                countMods++;
                return true;
            }
        }
        return false;
    }

    public Map.Entry<K, V>[] arrConstrict(Map.Entry<K, V>[] arr, int index) {
        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
        return Arrays.copyOf(arr, arr.length - 1);
    }

    @Override
    public Iterator iterator() {
        return new Iterator<V>() {
            int innerCountMods = countMods;
            int indexIter = 0;

            @Override
            public boolean hasNext() {
                if (countMods != innerCountMods) {
                   throw new ConcurrentModificationException();
                }
                return indexIter < elems.length;
            }

            @Override
            public V next() {
                 if (!hasNext()) {
                    throw new NoSuchElementException();
                 }
                 return (V) elems[indexIter++].getValue();
            }
        };
    }
}
