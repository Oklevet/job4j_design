package ru.job4j.kiss;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {
    public List<Integer> list = new ArrayList<>();

    @Before
    public void set() {
        list.add(9);
        list.add(4);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(19);
        list.add(5);
        list.add(13);
        list.add(8);
    }

    @Test
    public void minMaxMin() {
        int rsl = new MaxMin().min(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        int expected = 3;
        assertEquals(expected, rsl);
    }

    @Test
    public void maxMaxMin() {
        int rsl = new MaxMin().max(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        int expected = 19;
        assertEquals(expected, rsl);
    }
}