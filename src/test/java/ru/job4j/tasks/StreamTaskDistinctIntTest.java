package ru.job4j.tasks;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StreamTaskDistinctIntTest {

    @Test
    public void test() {
        assertEquals(
                List.of(1, 2, 3),
                StreamTaskDistinctInt.collect(new int[] {1, 2, 3, 1, 2, 3})
        );
    }
}