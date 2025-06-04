package ru.job4j.tasks.obj;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Task8Test {

    @Test
    public void whenCreateTask8() {
        Class<Task8> task = Task8.class;
        assertTrue(task.isInterface());
    }

}