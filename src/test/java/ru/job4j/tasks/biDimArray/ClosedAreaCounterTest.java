package ru.job4j.tasks.biDimArray;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClosedAreaCounterTest {

    @Test
    public void testCountClosedAreas() {
        ClosedAreaCounter closedAreaCounter = new ClosedAreaCounter();
        int[][] map = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1}
        };

        int result = closedAreaCounter.countClosedAreas(map);
        assertEquals(1, result);
    }

    @Test
    public void testNoClosedAreas() {
        ClosedAreaCounter closedAreaCounter = new ClosedAreaCounter();
        int[][] map = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        int result = closedAreaCounter.countClosedAreas(map);
        assertEquals(0, result);
    }

    @Test
    public void testMultipleClosedAreas() {
        ClosedAreaCounter closedAreaCounter = new ClosedAreaCounter();
        int[][] map = {
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1}
        };

        int result = closedAreaCounter.countClosedAreas(map);
        assertEquals(3, result);
    }

    @Test
    public void testEmptyMap() {
        ClosedAreaCounter closedAreaCounter = new ClosedAreaCounter();
        int[][] map = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        int result = closedAreaCounter.countClosedAreas(map);
        assertEquals(0, result);
    }
}
