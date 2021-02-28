package ru.job4j.generic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertNull;

public class SimpleArrayTest {

    @Test
    public void validAddAndValidGet() {
        int[] expected = new int[] {3};
        SimpleArray<Integer> rsl = new SimpleArray<>(1);
        rsl.add(3);
        assertThat(rsl.get(0), is(expected[0]));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidAdd() {
        SimpleArray<Integer> rsl = new SimpleArray<>(2);
        rsl.add(1);
        rsl.add(2);
        rsl.add(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidGet() {
        SimpleArray<Integer> rsl = new SimpleArray<>(2);
        rsl.add(1);
        rsl.get(111);
    }

    @Test
    public void validSet() {
        int[] expected = new int[] {3, 2};
        SimpleArray<Integer> rsl = new SimpleArray<>(2);
        rsl.add(3);
        rsl.add(23);
        rsl.set(1, 2);
        assertThat(rsl.get(1), is(expected[1]));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidSet() {
        int[] expected = new int[] {3, 2};
        SimpleArray<Integer> rsl = new SimpleArray<>(2);
        rsl.add(3);
        rsl.add(23);
        rsl.set(10, 2);
        assertThat(rsl.get(1), is(expected[1]));

    }

     @Test
    public void whenMultiCallhasNextThenTrue() {
        SimpleArray<Integer> it = new SimpleArray<>(3);
        Iterator<Integer> iterator = it.iterator();
         it.add(1);
         it.add(2);
         it.add(3);
         assertThat(iterator.hasNext(), is(true));
         assertThat(iterator.hasNext(), is(true));
     }

    @Test
    public void whenReadSequence() {
        SimpleArray<Integer> it = new SimpleArray<>(3);
        Iterator<Integer> iterator = it.iterator();
         it.add(1);
         it.add(2);
         it.add(3);
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void invalidReadSequence() {
        SimpleArray<Integer> it = new SimpleArray<>(1);
        Iterator<Integer> iterator = it.iterator();
         it.add(1);
         iterator.next();
         iterator.next();
    }

     @Test (expected = IndexOutOfBoundsException.class)
    public void remove() {
        int[] expected = new int[] {1, 3, 4};
        SimpleArray<Integer> rsl = new SimpleArray<>(4);
        rsl.add(1);
        rsl.add(2);
        rsl.add(3);
        rsl.add(4);
        rsl.remove(1);
         assertThat(rsl.get(0), is(expected[0]));
         assertThat(rsl.get(1), is(expected[1]));
         assertThat(rsl.get(2), is(expected[2]));
         assertNull(rsl.get(3));
    }
}