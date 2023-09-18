package ru.job4j.tasks.loop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class Task56Test {
    public String ln = System.lineSeparator();

    @Test
    public void when1And2And3And4Then3() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int[] rsl = {1, 2, 3, 4};
        Task56.loop(rsl);
        String expected = "3" + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void when3And2And1And3Then0() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int[] rsl = {3, 2, 1, 3};
        Task56.loop(rsl);
        String expected = "0" + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void when2And1And3And4Then2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int[] rsl = {2, 1, 3, 4};
        Task56.loop(rsl);
        String expected = "2" + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void when2And2And0And4Then1() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int[] rsl = {2, 2, 0, 4};
        Task56.loop(rsl);
        String expected = "1" + ln;
        assertThat(out.toString(), is(expected));
    }
}