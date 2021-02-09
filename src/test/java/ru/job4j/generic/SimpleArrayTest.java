package ru.job4j.generic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {

    @Test
    public void validAddAndValidGet() {
        int[] expected = new int[] {3};
        var rsl = new SimpleArray(1);
        rsl.add(3);
        assertThat(rsl.get(0), is(expected[0]));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidAdd() {
        SimpleArray rsl = new SimpleArray(2);
        rsl.add(1);
        rsl.add(2);
        rsl.add(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidGet() {
        SimpleArray rsl = new SimpleArray(2);
        rsl.add(1);
        rsl.get(111);
    }

    @Test
    public void validSet() {
        int[] expected = new int[] {3, 2};
        var rsl = new SimpleArray(2);
        rsl.add(3);
        rsl.add(23);
        rsl.set(1, 2);
        assertThat(rsl.get(1), is(expected[1]));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidSet() {
        int[] expected = new int[] {3, 2};
        var rsl = new SimpleArray(2);
        rsl.add(3);
        rsl.add(23);
        rsl.set(10, 2);
        assertThat(rsl.get(1), is(expected[1]));

    }

     @Test
    public void whenMultiCallhasNextThenTrue() {
        var it = new SimpleArray<Integer>(3);
         it.add(1);
         it.add(2);
         it.add(3);
         assertThat(it.hasNext(), is(true));
         assertThat(it.hasNext(), is(true));
     }

    @Test
    public void whenReadSequence() {
        var it = new SimpleArray<Integer>(3);
         it.add(1);
         it.add(2);
         it.add(3);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void invalidReadSequence() {
        var it = new SimpleArray<Integer>(1);
         it.add(1);
         it.next();
         it.next();
    }
}