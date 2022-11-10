package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList2() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).filteredOnAssertions(x -> assertThat(x.length()).isLessThan(5))
                .hasSize(2)
                .first()
                .isEqualTo("four");
    }

    @Test
    void checkList3() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).last().isNotNull().isEqualTo("five");
        assertThat(list).element(2).isNotNull().isEqualTo("three");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).filteredOnAssertions(x -> assertThat(x.length()).isGreaterThan(5))
                .hasSize(1)
                .first()
                .isEqualTo("second");
    }

    @Test
    void checkSet2() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).hasSize(5)
                .contains("four")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("fit");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first",  "second", "three", "four", "five");
        map.forEach((k, v) -> System.out.println(k + "  " + v + "         "));
        assertThat(map).hasSize(5)
                .containsKey("four")
                .containsKeys("first", "three")
                .containsValues(2, 4, 0)
                .doesNotContainKeys("ten", "eleven", "qwe")
                .doesNotContainValue(12)
                .doesNotContainEntry("three", 33)
                .doesNotContainEntry("qwe", 10)
                .containsEntry("second", 1)
                .containsEntry("five", 4);
    }
}