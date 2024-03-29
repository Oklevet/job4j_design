package ru.job4j.tasks;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class Task18ioTest {
    @Test
    public void shouldOutputStringPlusNumber() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        FirstTask18io.main(null);
        String expected = "Значение x равно 9" + System.lineSeparator() + "Значение x^2 равно 81";
        assertThat(out.toString(), is(expected));
    }
}