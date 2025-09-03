package ru.job4j.tasks.bidimarray;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChangeMachineTest {

    @Test
    public void testGetChangeVariantsFor10() {
        ChangeMachine changeMachine = new ChangeMachine();
        int[][] expected = {
                {1, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 1, 2, 1},
                {0, 1, 1, 3},
                {0, 1, 0, 5},
                {0, 0, 5, 0},
                {0, 0, 4, 2},
                {0, 0, 3, 4},
                {0, 0, 2, 6},
                {0, 0, 1, 8},
                {0, 0, 0, 10}
        };

        List<int[]> result = changeMachine.getChangeVariants(10);
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testGetChangeVariantsFor5() {
        ChangeMachine changeMachine = new ChangeMachine();
        int[][] expected = {
                {0, 1, 0, 0},
                {0, 0, 2, 1},
                {0, 0, 1, 3},
                {0, 0, 0, 5}
        };

        List<int[]> result = changeMachine.getChangeVariants(5);
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testGetChangeVariantsFor1() {
        ChangeMachine changeMachine = new ChangeMachine();
        int[][] expected = {
                {0, 0, 0, 1}
        };

        List<int[]> result = changeMachine.getChangeVariants(1);
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testGetChangeVariantsForInvalidAmount() {
        ChangeMachine changeMachine = new ChangeMachine();
        int[][] expected = {};

        List<int[]> result = changeMachine.getChangeVariants(0); // Неправильная сумма
        assertArrayEquals(expected, result.toArray());
    }
}
