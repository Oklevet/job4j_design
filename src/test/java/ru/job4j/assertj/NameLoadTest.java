package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkMapIsEmpty() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(nl::parse).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkMapIsEmptyMessageErr() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(nl::parse).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+");
    }

    @Test
    void checkParse() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(nl::parse)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkParseMessageErr() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(nl::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+");
    }

    @Test
    void checkValidateNotContainEqual() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(() -> nl.parse("qwe"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkValidateNotContainEqualMessage() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(() -> nl.parse("qwe"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+");
    }

    @Test
    void checkValidateNotContainEqualVars() {
        NameLoad nl = new NameLoad();
        String str = "qwe";
        assertThatThrownBy(() -> nl.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str);
    }

    @Test
    void checkValidateStartEqual() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(() -> nl.parse("=qwe"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkValidateStartEqualMessage() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(() -> nl.parse("=qwe"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+");
    }

    @Test
    void checkValidateStartEqualVars() {
        NameLoad nl = new NameLoad();
        String str = "=qwe";
        assertThatThrownBy(() -> nl.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str);
    }

    @Test
    void checkValidateEndEqual() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(() -> nl.parse("qwe="))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkValidateEndEqualMessage() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(() -> nl.parse("qwe="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+");
    }

    @Test
    void checkValidateEndEqualVars() {
        NameLoad nl = new NameLoad();
        String str = "qwe=";
        assertThatThrownBy(() -> nl.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str);
    }
}