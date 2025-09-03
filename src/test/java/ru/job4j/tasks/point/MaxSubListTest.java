package ru.job4j.tasks.point;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class MaxSubListTest {

    @Test
    public void whenArrayHasMixedPositiveAndNegativeNumbersThenFindMaxSubarray() {
        MaxSubList maxSubList = new MaxSubList();
        int[] array = {2, -8, 3, -2, 4, -10};

        MaxRange result = maxSubList.count(array);

        assertThat(result.start(), is(2));
        assertThat(result.ent(), is(4));
    }

    @Test
    public void whenArrayHasOnlyPositiveNumbersThenFindMaxSubarray() {
        MaxSubList maxSubList = new MaxSubList();
        int[] array = {1, 2, 3, 4, 5};

        MaxRange result = maxSubList.count(array);

        assertThat(result.start(), is(0));
        assertThat(result.ent(), is(4));
    }

    @Test
    public void whenArrayHasOnlyNegativeNumbersThenFindMaxSubarray() {
        MaxSubList maxSubList = new MaxSubList();
        int[] array = {-1, -2, -3, -4, -5};

        MaxRange result = maxSubList.count(array);

        assertThat(result.start(), is(0));
        assertThat(result.ent(), is(0));
    }

    @Test
    public void whenArrayHasSingleElementThenThatIsMaxSubarray() {
        MaxSubList maxSubList = new MaxSubList();
        int[] array = {10};

        MaxRange result = maxSubList.count(array);

        assertThat(result.start(), is(0));
        assertThat(result.ent(), is(0));
    }

    @Test
    public void whenArrayHasZeroesThenFindMaxSubarray() {
        MaxSubList maxSubList = new MaxSubList();
        int[] array = {0, 0, 0, 0, 0};

        MaxRange result = maxSubList.count(array);

        assertThat(result.start(), is(0));
        assertThat(result.ent(), is(0));
    }
}