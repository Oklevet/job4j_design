package ru.job4j.tasks.string;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class LogLineTest {
    @Test
    public void whenParseSingleLine() {
        var line = new LogLine().parse(
                "WARNING [threads [zqfz [wbye [zfq]]] - 1] wqqa [e] zqw"
        );
        assertThat(line.level(),
                is("WARNING"));
        assertThat(line.threads(),
                is("[threads [zqfz [wbye [zfq]]] - 1]"));
        assertThat(line.text(),
                is("wqqa [e] zqw"));
    }

    @Test
    public void whenLevelError() {
        var line = new LogLine().parse(
                "ERROR [threads [wcxf [czed [ayya [fye]]]] - 0] eaba yzd"
        );
        assertThat(line.level(),
                is("ERROR"));
        assertThat(line.threads(),
                is("[threads [wcxf [czed [ayya [fye]]]] - 0]"));
        assertThat(line.text(),
                is("eaba yzd"));
    }

    @Test
    public void whenLevelInfo() {
        var line = new LogLine().parse(
                "INFO [threads [zqfz [wbye [zfq]]] - 1] qdcq"
        );
        assertThat(line.level(),
                is("INFO"));
        assertThat(line.threads(),
                is("[threads [zqfz [wbye [zfq]]] - 1]"));
        assertThat(line.text(),
                is("qdcq"));
    }
}