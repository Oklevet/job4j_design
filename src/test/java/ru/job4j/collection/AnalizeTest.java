package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenChanAddDel() {
        List<Analize.User> prev = List.of(
                new Analize.User(1, "qwe"),
                new Analize.User(2, "qweqwe"),
                new Analize.User(3, "asd"),
                new Analize.User(4, "asdasd")
        );
        List<Analize.User> curr = List.of(
                new Analize.User(1, "qwezxc"),
                new Analize.User(3, "jkljkl"),
                new Analize.User(5, "erterte"),
                new Analize.User(6, "asdasd")
        );
        Analize.Info rsl = new Analize.Info(Analize.diff(prev, curr));
        Analize.Info expected = new Analize.Info(2, 2, 2);
        assertThat(rsl.toString(), is(expected.toString()));
    }

    @Test
    public void whenDel() {
        List<Analize.User> prev = List.of(
                new Analize.User(1, "qwe"),
                new Analize.User(2, "qweqwe"),
                new Analize.User(3, "asd"),
                new Analize.User(4, "asdasd")
        );
        List<Analize.User> curr = List.of(
                new Analize.User(1, "qwe"),
                new Analize.User(2, "qweqwe"),
                new Analize.User(3, "asd"),
                new Analize.User(4, "asdasd")
        );
        Analize.Info rsl = new Analize.Info(Analize.diff(prev, curr));
        Analize.Info expected = new Analize.Info(0, 0, 0);
        assertThat(rsl.toString(), is(expected.toString()));
    }

    @Test
    public void whenSimilar() {
        List<Analize.User> prev = List.of(
                new Analize.User(1, "qwe"),
                new Analize.User(2, "qweqwe"),
                new Analize.User(3, "asd"),
                new Analize.User(4, "asdasd")
        );
        List<Analize.User> curr = List.of(
                new Analize.User(1, "qwe"),
                new Analize.User(2, "qweqwe"),
                new Analize.User(3, "asd"),
                new Analize.User(4, "asdasd")
        );
        Analize.Info rsl = new Analize.Info(Analize.diff(prev, curr));
        Analize.Info expected = new Analize.Info(0, 0, 0);
        assertThat(rsl.toString(), is(expected.toString()));
    }

    @Test
    public void whenDelChan() {
        List<Analize.User> prev = List.of(
                new Analize.User(1, "qwe"),
                new Analize.User(2, "qweqwe"),
                new Analize.User(3, "asd"),
                new Analize.User(4, "asdasd")
        );
        List<Analize.User> curr = List.of(
                new Analize.User(1, "qweasdasd")
        );
        Analize.Info rsl = new Analize.Info(Analize.diff(prev, curr));
        Analize.Info expected = new Analize.Info(0, 1, 3);
        assertThat(rsl.toString(), is(expected.toString()));
    }
}