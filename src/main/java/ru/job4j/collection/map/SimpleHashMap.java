package ru.job4j.collection.map;

import java.util.*;


public class SimpleHashMap<K, V> implements Iterable<K> {
    private SimpleHashMap.Entry[] elems = new SimpleHashMap.Entry[2];
    private static float loadfactor = 0.75F;
    private int count = 0;
    private int countMods = 0;

    public int getSize() {
        return elems.length;
    }

    public int getCount() {
        return count;
    }

    public boolean insert(K key, V value) {
        checkLength();
        int h = hash(key, elems);
        if (elems[h] == null) {
            elems[h] = new SimpleHashMap.Entry<>(key, value);
            count++;
            countMods++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        int h = hash(key, elems);
        Entry elem = elems[h];
        if (elem != null) {
            if (Objects.equals(key, elem.key)) {
                return (V) elem.value;
            }
        }
        return null;
    }

    public boolean delete(K key) {
        int h = hash(key, elems);
        if (elems[h] != null && Objects.equals(key, elems[h].getKey())) {
            elems[h] = null;
            count--;
            countMods++;
            return true;
        }
        return false;
    }

    private void checkLength() {
        int length = (int) Math.round(elems.length * loadfactor - 1);
        if (count >= length) {
            int lengthNew = elems.length * 2;
            SimpleHashMap.Entry[] temp = new SimpleHashMap.Entry[lengthNew];
            for (Entry elem : elems) {
                if (elem != null) {
                    temp[hash((K) elem.getKey(), temp)] = elem;
                }
            }
            elems = temp;
        }
    }

    private int hash(K key, SimpleHashMap.Entry[] array) {
        int h = key.hashCode();
        int shuffle = h ^ h >>> 16;
        return (array.length - 1) & shuffle;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<Object>() {
            final int innerCountMods = countMods;
            int indexIter = 0;

            @Override
            public boolean hasNext() {
                if (countMods != innerCountMods) {
                   throw new ConcurrentModificationException();
                }
                return indexIter < elems.length && getCount() != 0;
            }

            @Override
            public Object next() {
                 if (!hasNext()) {
                    throw new NoSuchElementException();
                 }
                 for (int i = indexIter; i < getSize(); i++) {
                     Entry elem = elems[i];
                     indexIter++;
                     if (elem != null) {
                         return elem.getValue();
                     }
                 }
                 return null;
            }
        };
    }

     static class Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
