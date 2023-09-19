package ru.job4j.tasks.loop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Task86Test {

    public String ln = System.lineSeparator();

    @Test
    public void when18And27Then18And27() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int[] nums = {18, 27};
        Task86.loop(nums);
        String expected = "18 27" + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void when36And39Then36() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int[] nums = {36, 39};
        Task86.loop(nums);
        String expected = "36" + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void when12And33ThenMsg() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int[] nums = {12, 33};
        Task86.loop(nums);
        String expected = "Стабильных чисел нет" + ln;
        assertThat(out.toString(), is(expected));
    }
}