package ru.job4j.tasks.biDimArray;

import org.junit.Test;
import static org.junit.Assert.*;

public class IslandCounterTest {

    @Test
    public void testFindLargestIsland() {
        IslandCounter islandCounter = new IslandCounter();
        int[][] map = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0}
        };

        int result = islandCounter.findLargestIsland(map);
        assertEquals(4, result); // Самый большой остров состоит из 4 клеток
    }

    @Test
    public void testEmptyMap() {
        IslandCounter islandCounter = new IslandCounter();
        int[][] map = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int result = islandCounter.findLargestIsland(map);
        assertEquals(0, result); // На карте нет островов
    }

    @Test
    public void testSingleIsland() {
        IslandCounter islandCounter = new IslandCounter();
        int[][] map = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        int result = islandCounter.findLargestIsland(map);
        assertEquals(25, result); // Один большой остров из 25 клеток
    }

    @Test
    public void testMultipleIslands() {
        IslandCounter islandCounter = new IslandCounter();
        int[][] map = {
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int result = islandCounter.findLargestIsland(map);
        assertEquals(5, result); // Самый большой остров состоит из 5 клеток
    }
}