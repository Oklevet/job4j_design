package ru.job4j.odd;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;


public class GeneratorTest {

    @Test
    public void produceValid() {
        Generator generator = new Generator();
        String sample = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "qwe",
                "subject", "asd"
        );
        String out = generator.produce(sample, map);
        Assert.assertThat(out, is("I am a qwe, Who are asd?"));
    }

    @Test
    public void produceValidMapBigger() {
        Generator generator = new Generator();
        String sample = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "qwe",
                "subject", "asd",
                "zxczxc", "dfg"
        );
        String out = generator.produce(sample, map);
        Assert.assertThat(out, is("I am a qwe, Who are asd?"));
    }

    @Test(expected = NullPointerException.class)
    public void produceInvalidMapLesser() {
        Generator generator = new Generator();
        String sample = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "qwe"
        );
        String out = generator.produce(sample, map);
    }

    @Test(expected = NotFindKey("Map hasn't needed key").class)
    public void produceInvalidKey() {
        Generator generator = new Generator();
        String sample = "I am a ${iiiii}, Who are ${tttt}?";
        Map map = Map.of(
                "name", "qwe",
                "subject", "asd",
                "zxczxc", "dfg"
        );
        String out = generator.produce(sample, map);
    }
    @Test
    public void produceValidMap2() {
        Generator generator = new Generator();
        String sample = "${name}${subject}";
        Map map = Map.of(
                "name", "qwe",
                "subject", "asd",
                "zxczxc", "dfg"
        );
        String out = generator.produce(sample, map);
        Assert.assertThat(out, is("qweasd"));
    }

    @Test(expected = NotFindKey("Map hasn't needed key").class)
    public void produceInvalidKey2() {
        Generator generator = new Generator();
        String sample = "${name{subject}}";
        Map map = Map.of(
                "name", "qwe",
                "subject", "asd",
                "zxczxc", "dfg"
        );
        String out = generator.produce(sample, map);
    }

    @Test
    public void produceValidMap3() {
        Generator generator = new Generator();
        String sample = "${name${subject}}";
        Map map = Map.of(
                "name", "qwe",
                "subject", "asd",
                "zxczxc", "dfg"
        );
        String out = generator.produce(sample, map);
        Assert.assertThat(out, is("${nameasd}"));
    }
}