package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> val = head;
        head = head.next;
        return val.value;
    }

    public T deleteLast() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> curr = head;
        Node<T> prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == prev) {
            head = null;
        }
        prev.next = null;
        return curr.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
