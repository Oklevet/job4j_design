package ru.job4j.tasks.oop;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;

public class Task1Test {
    @Test
    public void checkMainOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Task1.main(null);
        String expected = new StringJoiner(
                System.lineSeparator(), "", System.lineSeparator()
        ).add("I would like to drink a cup of tea.")
                .toString();
        MatcherAssert.assertThat(out.toString(), is(expected));
    }

    @Test
    public void checkTeaOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Tea().prepare();
        String expected = new StringJoiner(
                System.lineSeparator(), "", System.lineSeparator()
        ).add("I would like to drink a cup of tea.")
                .toString();
        MatcherAssert.assertThat(out.toString(), is(expected));
    }
}