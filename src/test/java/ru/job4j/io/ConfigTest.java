package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithCommentsAndEmptyStrings() {
        /**
         * Paths 4 tests
         * String path = "./data/pair_without_comment.properties";
         * String path = ".src/main//java//ru//job4j/chapter_006/data/pair_without_comment.properties";
         */
        String path = "configNote.txt";
        Config config = new Config(path);
        config.load();
        config.toString();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("qwe"), is("qweqwe"));
        assertThat(config.value("asdasd"), is("1a23"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithWrongEquality() {
        String path = "configWrongEqual.txt";
        Config config = new Config(path);
        config.load();
        config.toString();
    }

    @Test
    public void whenPairWithComments() {
        String path = "src/data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        config.toString();
        assertThat(config.value("name"), is("Petr Arsentev"));
    }

    @Test
    public void whenPairWithoutComment() {
        String path = "src/data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
   }

    @Test
    public void whenAppPostgresInData() {
        String path = "src/data/app2.properties";
        Config config = new Config(path);
        config.load();
        config.toString();
        assertThat(config.value("login"), is("postgres"));
    }
}