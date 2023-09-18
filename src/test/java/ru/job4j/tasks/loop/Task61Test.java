package ru.job4j.tasks.loop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class Task61Test {
    public String ln = System.lineSeparator();

    @Test
    public void whenTestThen110And220And330And354And440And453() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Task61.loop();
        String expected = "110 220 330 354 440 453" + ln;
        assertThat(out.toString(), is(expected));
    }
}