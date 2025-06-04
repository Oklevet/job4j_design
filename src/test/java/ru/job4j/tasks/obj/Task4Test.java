package ru.job4j.tasks.obj;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Task4Test {

    @Test
    public void whenCreateTask4() {
        Class<Task4> task = Task4.class;
        assertTrue(task.isEnum());
    }
}