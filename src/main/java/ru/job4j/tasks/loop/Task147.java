package ru.job4j.tasks.loop;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Task147 {
    public static void loop(int num, int[] tickets) {
        AtomicInteger buyer = new AtomicInteger(0);
        AtomicInteger nums = new AtomicInteger(num);
        AtomicInteger cancel = new AtomicInteger(0);

        Arrays.stream(tickets).forEach(x -> {
            if (nums.get() - x >= 0) {
                buyer.addAndGet(1);
                nums.addAndGet(-x);
            } else
                cancel.addAndGet(1);
        });
        System.out.println("Покупатели: " + buyer.get() + ", отказано: " + cancel.get());
    }
}
