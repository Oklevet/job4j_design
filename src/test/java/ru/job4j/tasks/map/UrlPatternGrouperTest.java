package ru.job4j.tasks.map;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

public class UrlPatternGrouperTest {

    @Test
    public void whenUrlsGroupedWithSamePatternsThenCorrectStatisticsAreReturned() {
        UrlPatternGrouper grouper = new UrlPatternGrouper();

        List<String> urls = Arrays.asList(
                "/exercise",
                "/exercise/217",
                "/exercise/218",
                "/exercise/218/task-view/1255",
                "/",
                "/exercise",
                "/exercise/217",
                "/exercise/218",
                "/exercise/217",
                "/exercise/218",
                "/exercise/218/task-view/1255",
                "/interview/9",
                "/exercise",
                "/exercise/217",
                "/exercise/218",
                "/exercise/218/task-view/1255",
                "/exercise/218/task-view/1256"
        );

        assertThat(grouper.groupUrls(urls))
                .hasSize(4)
                .extracting(UrlPatternGrouper.PageStatistic::getPattern, UrlPatternGrouper.PageStatistic::getCount)
                .containsExactlyInAnyOrder(
                        tuple("/exercise", 3),
                        tuple("/exercise/..", 12),
                        tuple("/", 1),
                        tuple("/interview/..", 1));
    }

    @Test
    public void whenNoUrlsProvidedThenEmptyStatisticsAreReturned() {
        UrlPatternGrouper grouper = new UrlPatternGrouper();

        List<String> urls = Arrays.asList();

        List<UrlPatternGrouper.PageStatistic> result = grouper.groupUrls(urls);

        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void whenSingleRootUrlProvidedThenCorrectStatisticsAreReturned() {
        UrlPatternGrouper grouper = new UrlPatternGrouper();

        List<String> urls = Arrays.asList("/");

        assertThat(grouper.groupUrls(urls))
                .hasSize(1)
                .extracting(UrlPatternGrouper.PageStatistic::getPattern, UrlPatternGrouper.PageStatistic::getCount)
                .containsExactlyInAnyOrder(
                        tuple("/", 1));
    }

    @Test
    public void whenDifferentUrlsProvidedThenCorrectStatisticsAreReturned() {
        UrlPatternGrouper grouper = new UrlPatternGrouper();

        List<String> urls = Arrays.asList(
                "/exercise",
                "/interview",
                "/exercise/214",
                "/interview/9"
        );

        assertThat(grouper.groupUrls(urls))
                .hasSize(4)
                .extracting(UrlPatternGrouper.PageStatistic::getPattern, UrlPatternGrouper.PageStatistic::getCount)
                .containsExactlyInAnyOrder(
                        tuple("/exercise", 1),
                        tuple("/exercise/..", 1),
                        tuple("/interview", 1),
                        tuple("/interview/..", 1));
    }

    @Test
    public void whenOnlyExerciseUrlsProvidedThenCorrectStatisticsAreReturned() {
        UrlPatternGrouper grouper = new UrlPatternGrouper();

        List<String> urls = Arrays.asList(
                "/exercise",
                "/exercise/217",
                "/exercise/218/task-view/1255"
        );

        assertThat(grouper.groupUrls(urls))
                .hasSize(2)
                .extracting(UrlPatternGrouper.PageStatistic::getPattern, UrlPatternGrouper.PageStatistic::getCount)
                .containsExactlyInAnyOrder(
                        tuple("/exercise", 1),
                        tuple("/exercise/..", 2));
    }
}