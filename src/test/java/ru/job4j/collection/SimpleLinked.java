package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinked<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int modCount = 0;
    private int size = 0;

    public void add(T model) {
        Node<T> node = new Node<T>(null, null, model);
        if (size == 0) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index,size);
        Node<T> curr = first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return curr.elem;
            }
            curr = curr.next;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() throws ConcurrentModificationException {
        return new Iterator<T>() {
             int expectedModCount = modCount;
             Node<T> indexIter = first;


            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return indexIter.next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T elem = indexIter.elem;
                indexIter = indexIter.next;
                return elem;
            }
        };
    }

    private class Node<T> {
        Node<T> next;
        Node<T> prev;
        T elem;

        public Node(Node<T> next, Node<T> prev, T elem) {
            this.next = next;
            this.prev = prev;
            this.elem = elem;
        }
    }
}
