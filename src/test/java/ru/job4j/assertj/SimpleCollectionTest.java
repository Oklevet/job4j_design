package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

class SimpleCollectionTest {

    /**
     * размер
     * содержит элементы
     * содержит это в любом порядке, дубликаты не важны
     * содержит только это и только в указанном порядке
     * содержит только это в любом порядке
     * содержит хотя бы один из
     * не содержит ни одного из
     * начинается с последовательности
     * заканчивается на последовательность
     * содержит последовательность
     */
    @Test
    void generalAssert() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(sc).isNotEmpty()
                .hasSize(5)
                .contains(1, 5, 4)
                .containsOnly(1, 5, 4, 3)
                .containsExactly(1, 1, 3, 4, 5)
                .containsExactlyInAnyOrder(5, 1, 3, 4, 1)
                .containsAnyOf(200, 100, 3)
                .doesNotContain(0, 6)
                .startsWith(1, 1)
                .endsWith(4, 5)
                .containsSequence(1, 3);
    }

    /**
     * все элементы выполняют условие
     * хотя бы один элемент выполняет условие
     */
    @Test
    void satisfyAssert() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(sc).isNotNull()
                .allSatisfy(e -> {
                    assertThat(e).isLessThan(10);
                    assertThat(e).isGreaterThan(0);
                })
                .anySatisfy(e -> {
                    assertThat(e).isLessThan(5);
                    assertThat(e).isEqualTo(3);
                })
                .allMatch(e -> e < 10)
                .anyMatch(e -> e == 5)
                .noneMatch(e -> e < 1);
    }

    /**
     * первый элемент
     * элемент по индексу
     * последний элемент
     */
    @Test
    void checkNavigationList() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(sc).first().isEqualTo(1);
        assertThat(sc).element(0).isNotNull()
                .isEqualTo(1);
        assertThat(sc).last().isNotNull()
                .isEqualTo(5);
    }

    /**
     * фильтруем источник по предикату и работаем с результатом фильтрации
     * фильтруем с помощью assertThat() и работаем с результатом фильтрации
     */
    @Test
    void checkFilteredList() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(sc).filteredOn(e -> e > 1).first().isEqualTo(3);
        assertThat(sc).filteredOnAssertions(e -> assertThat(e).isLessThan(3))
                .hasSize(2)
                .first().isEqualTo(1);
    }

    /**
     * содержит ключи
     * содержит значения
     * не содержит ключ
     * не содержит значение
     * содержит пару ключ-значение
     */
    @Test
    void assertMap() {
        Map<Integer, String> map = Map.of(
                1, "1", 2, "2", 3, "3");
        assertThat(map).hasSize(3)
                .containsKeys(1, 3, 2)
                .containsValues("3", "1", "2")
                .doesNotContainKey(0)
                .doesNotContainValue("0")
                .containsEntry(2, "2");
    }
}