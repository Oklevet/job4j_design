package ru.job4j.tasks.sort;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class CommonNumberFinderTest {

    @Test
    public void testFindCommonNumber() {
        CommonNumberFinder finder = new CommonNumberFinder();
        List<Integer> list1 = Arrays.asList(3, 1, 5, 2, 4);
        List<Integer> list2 = Arrays.asList(6, 4, 7, 5);
        List<Integer> list3 = Arrays.asList(9, 5, 7, 8);

        int result = finder.findCommonNumber(list1, list2, list3);
        assertThat(result, is(5));
    }

    @Test
    public void testFindCommonNumberNoCommon() {
        CommonNumberFinder finder = new CommonNumberFinder();
        List<Integer> list1 = Arrays.asList(3, 1, 2);
        List<Integer> list2 = Arrays.asList(5, 4, 6);
        List<Integer> list3 = Arrays.asList(8, 7, 9);

        int result = finder.findCommonNumber(list1, list2, list3);
        assertThat(result, is(-1));
    }

    @Test
    public void testFindCommonNumberMultipleCommon() {
        CommonNumberFinder finder = new CommonNumberFinder();
        List<Integer> list1 = Arrays.asList(5, 1, 4, 3, 2);
        List<Integer> list2 = Arrays.asList(6, 5, 3, 4);
        List<Integer> list3 = Arrays.asList(7, 5, 3, 2);

        int result = finder.findCommonNumber(list1, list2, list3);
        assertThat(result, is(3));
    }

    @Test
    public void testFindCommonNumberWithEmptyLists() {
        CommonNumberFinder finder = new CommonNumberFinder();
        List<Integer> list1 = Arrays.asList();
        List<Integer> list2 = Arrays.asList();
        List<Integer> list3 = Arrays.asList();

        int result = finder.findCommonNumber(list1, list2, list3);
        assertThat(result, is(-1));
    }
}