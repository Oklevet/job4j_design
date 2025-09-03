package ru.job4j.tasks.obj;

import java.util.Deque;
import java.util.LinkedList;

public class Task11 {
    Deque<Integer> deque = new LinkedList<>();

    public void init() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
    }
}
