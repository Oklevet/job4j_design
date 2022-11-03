package ru.job4j.tasks.condition;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Task53Test {
    public String ln = System.lineSeparator();

    @Test
    public void when390Then281() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Task53.transform(390);
        String expected = "281" + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void when333Then444() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Task53.transform(333);
        String expected = "444" + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenMinus900ThenMinus811() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Task53.transform(-900);
        String expected = "-811" + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void when999Then999() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Task53.transform(999);
        String expected = "999" + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenMinus109ThenMinus209() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Task53.transform(-109);
        String expected = "-209" + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void when100Then11() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Task53.transform(100);
        String expected = "111" + ln;
        assertThat(out.toString(), is(expected));
    }

}