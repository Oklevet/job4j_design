package ru.job4j.tasks.list;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CLParserTest {

    @Test
    public void whenFlagO() {
        String[] args = new String[]{"-o", "/some/path"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.hasOutputPath(), is(true));
        assertThat(parser.outputPath(), equalTo("/some/path"));
    }

    @Test
    public void whenFlagP() {
        String[] args = new String[]{"-p", "log_"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.hasPrefix(), is(true));
        assertThat(parser.prefix(), equalTo("log_"));
    }

    @Test
    public void whenFlagS() {
        String[] args = new String[]{"-s"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.isShortStatistic(), is(true));
    }

    @Test
    public void whenFlagF() {
        String[] args = new String[]{"-f"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.isFullStatistic(), is(true));
    }

    @Test
    public void whenFlagA() {
        String[] args = new String[]{"-a"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.isAddMode(), is(true));
    }

    @Test
    public void whenAllIsNormal() {
        String[] args = new String[]{"-s", "-a", "-p", "test_", "input.txt"};
        CLParser parser = new CLParser(args);
        parser.parse();
        assertThat(parser.inputs(), equalTo(List.of("input.txt")));
    }

    @Test
    public void whenNoInputFiles() {
        String[] args = new String[]{"-s", "-a", "-p", "test_"};
        CLParser parser = new CLParser(args);
        assertThat(parser.parse(), is(false));
        assertThat(parser.description(), equalTo(List.of("Don't contains input files.")));
    }

    @Test
    public void whenNonArgs() {
        CLParser parser = new CLParser(new String[]{});
        assertThat(parser.parse(), is(false));
        assertThat(parser.description(), equalTo(List.of(
                "Don't config statistic flags -s of -f.",
                "Don't contains input files."
        )));
    }

    @Test
    public void whenNonArgsStatistic() {
        CLParser parser = new CLParser(new String[]{"in1.txt"});
        assertThat(parser.parse(), is(false));
        assertThat(parser.description(), equalTo(List.of("Don't config statistic flags -s of -f.")));
    }
}
