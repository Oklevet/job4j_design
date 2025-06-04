package ru.job4j.tasks.obj;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task15Test {

    Class<?> cl;

    @Before
    public void init() {
        Task15 t = new Task15();
        cl = t.nested.getClass();
    }

    @Test
    public void whenLocalClassThenFalse() {
        assertFalse(cl.isLocalClass());
    }

    @Test
    public void whenMemberClassThenFalse() {
        assertFalse(cl.isMemberClass());
    }

    @Test
    public void whenStaticThenFalse() {
        assertFalse(Modifier.isStatic(cl.getModifiers()));
    }

    @Test
    public void whenAnonymousClassThenTrue() {
        assertTrue(cl.isAnonymousClass());
    }

}