package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedTest {
    SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();

    @Test
    public void whenAddAndGet() {
        simpleLinked.add(1);
        simpleLinked.add(2);
        Integer expected = simpleLinked.get(1);
        assertThat(expected, is(2));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenConcurrMod() {
        simpleLinked.add(1);
        Iterator<Integer> iterator = simpleLinked.iterator();
        simpleLinked.add(1);
        iterator.next();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenOutBound() {
        simpleLinked.add(1);
        assertThat(simpleLinked.get(1), is(0));
    }
}