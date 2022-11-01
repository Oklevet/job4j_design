package ru.job4j.tasks;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortThenComparingMethodTest {

    @Test
    public void test() {
        SortThenComparingMethod.User user1 = new SortThenComparingMethod.User("C", 10);
        SortThenComparingMethod.User user2 = new SortThenComparingMethod.User("B", 20);
        SortThenComparingMethod.User user3 = new SortThenComparingMethod.User("A", 15);
        SortThenComparingMethod.User user4 = new SortThenComparingMethod.User("B", 11);
        SortThenComparingMethod.User user5 = new SortThenComparingMethod.User("A", 12);
        List<SortThenComparingMethod.User> input = Arrays.asList(user1, user2, user3, user4, user5);
        List<SortThenComparingMethod.User> expect = Arrays.asList(user3, user5, user2, user4, user1);
        input.sort(SortThenComparingMethod.thenComparing());
        assertEquals(expect, input);
    }
}