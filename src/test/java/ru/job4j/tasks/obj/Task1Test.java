package ru.job4j.tasks.obj;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class Task1Test {

    @Test
    public void whenCreateTask1() {
        var task = new Task1();
        assertThat(task, is(notNullValue()));
    }
}