package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int size = 0;

    public T pop() {
        size--;
        return linked.deleteLast();
    }

    public void push(T value) {
        size++;
        linked.add(value);
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
}
