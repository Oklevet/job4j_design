package ru.job4j.tasks.map;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class UniqueWordsFinderTest {

    @Test
    public void testFindUniqueWordsWithDuplicates() {
        UniqueWordsFinder uniqueWordsFinder = new UniqueWordsFinder();
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
        List<String> expected = Arrays.asList("orange", "grape");

        List<String> result = uniqueWordsFinder.findUniqueWords(words);
        assertEquals(expected, result);
    }

    @Test
    public void testFindUniqueWordsAllUnique() {
        UniqueWordsFinder uniqueWordsFinder = new UniqueWordsFinder();
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape");
        List<String> expected = Arrays.asList("apple", "banana", "orange", "grape");

        List<String> result = uniqueWordsFinder.findUniqueWords(words);
        assertEquals(expected, result);
    }

    @Test
    public void testFindUniqueWordsEmptyList() {
        UniqueWordsFinder uniqueWordsFinder = new UniqueWordsFinder();
        List<String> words = new ArrayList<>();
        List<String> expected = new ArrayList<>();

        List<String> result = uniqueWordsFinder.findUniqueWords(words);
        assertEquals(expected, result);
    }

    @Test
    public void testFindUniqueWordsNoUnique() {
        UniqueWordsFinder uniqueWordsFinder = new UniqueWordsFinder();
        List<String> words = Arrays.asList("apple", "apple", "banana", "banana");
        List<String> expected = new ArrayList<>();

        List<String> result = uniqueWordsFinder.findUniqueWords(words);
        assertEquals(expected, result);
    }
}