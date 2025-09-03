package ru.job4j.tasks.obj;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class Task3Test {

    @Test
    public void whenCreateTask3() {
        var task = new Task3();
        assertThat(task, is(notNullValue()));
    }

    @Test
    public void whenCheckVariable() {
        var task = new Task3();
        int x = task.x;
        assertThat(task, is(notNullValue()));
    }

    @Test
    public void whenMethodInvoke() {
        var task = new Task3();
        int x = task.getX();
        assertThat(x, is(3));
    }

}