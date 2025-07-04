package ru.job4j.tasks.obj;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class Task6Test {

    @Test
    public void whenCheckVariable() {
        var task = new Task6();
        int x = task.getAge();
        assertThat(x, is(20));
    }

    @Test
    public void whenCheckConstructor() {
        var task = new Task6("name", "surname");
        assertThat(task, is(notNullValue()));
    }

}