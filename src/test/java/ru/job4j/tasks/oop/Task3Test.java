package ru.job4j.tasks.oop;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Task3Test {
    @Test
    public void checkMainOutput() {
        var methods = Task3.class.getDeclaredMethods();
        assertThat(methods.length, is(1));
        var method = methods[0];
        assertThat(method.getName(), is("output"));
        var params = method.getParameters();
        assertThat(params.length, is(1));
        assertThat(params[0].getType().getName(), is(String.class.getName()));
    }
}