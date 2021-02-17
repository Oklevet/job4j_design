package ru.job4j.collection.set;

import org.junit.Test;
import ru.job4j.collection.SimpleArray;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAdd() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(2);
        assertThat(array.iterator().next(), is(2));
    }

    @Test
    public void whenAddDuble() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(2);
        assertThat(array.iterator().next(), is(2));
        assertThat(array.add(2), is(false));
    }

    @Test
    public void whenAddNull() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(2);
        array.add(null);
        Iterator<Integer> it = array.iterator();
        assertThat(it.next(), is(2));
        assertNull(it.next());
    }
}