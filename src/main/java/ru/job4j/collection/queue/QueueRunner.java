package ru.job4j.collection.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueRunner {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Queue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("first");
        blockingQueue.offer("second");
        blockingQueue.offer("third");
        blockingQueue.offer("fourth");

        queue.add("first");
        queue.add("second");
        queue.add("third");

        for (String string : queue) {
            System.out.println(string);
        }

        queue.remove();
        System.out.println();
        System.out.println("State of Queue after remove: ");

        for (String string : queue) {
            System.out.println(string);
        }

        System.out.println("State of blockingQueue: ");
        for (String string : blockingQueue) {
            System.out.println(string);
        }
    }
}
