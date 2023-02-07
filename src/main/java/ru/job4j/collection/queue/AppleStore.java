package ru.job4j.collection.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer customer = null;
        if (count == 0) {
            return null;
        }

        for (int i = 0; i < count; i++) {
            if (queue.peek() == null) {
                return customer.name();
            }
            customer = queue.poll();
        }
        return customer.name();
    }

    public String getFirstUpsetCustomer() {
        Customer customer;
        for (int i = 0; i < count; i++) {
            customer = queue.poll();
            if (queue.peek() == null) {
                return customer.name();
            }
        }
        return queue.poll().name();
    }
}
