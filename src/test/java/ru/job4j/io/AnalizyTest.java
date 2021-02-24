package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void addFewWorking() {
        Analizy analizy = new Analizy();
        File actualFile = new File("serverLogsTests/serverLog1.csv");
        analizy.unavailable("serverLogsTests/serverLog1.txt", "serverLogsTests/serverLog1.csv");
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(actualFile))) {
            list = reader
                    .lines()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> listExpect = new ArrayList<>();
        listExpect.add("10:57:01;10:59:01");
        listExpect.add("11:01:02;11:02:02");
        assertThat(list, is(listExpect));
    }

    @Test
    public void allNotWork() {
        Analizy analizy = new Analizy();
        File actualFile = new File("serverLogsTests/serverLog2.csv");
        analizy.unavailable("serverLogsTests/serverLog2.txt", "serverLogsTests/serverLog2.csv");
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(actualFile))) {
            list = reader
                    .lines()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> listExpect = new ArrayList<>();
        listExpect.add("10:57:01; still not working");
        assertThat(list, is(listExpect));
    }

    @Test
    public void allWork() {
        Analizy analizy = new Analizy();
        File actualFile = new File("serverLogsTests/serverLog3.csv");
        analizy.unavailable("serverLogsTests/serverLog3.txt", "serverLogsTests/serverLog3.csv");
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(actualFile))) {
            list = reader
                    .lines()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> listExpect = new ArrayList<>();
        assertThat(list, is(listExpect));
    }

    @Test
    public void firstNotWork() {
        Analizy analizy = new Analizy();
        File actualFile = new File("serverLogsTests/serverLog4.csv");
        analizy.unavailable("serverLogsTests/serverLog4.txt", "serverLogsTests/serverLog4.csv");
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(actualFile))) {
            list = reader
                    .lines()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> listExpect = new ArrayList<>();
        listExpect.add("10:58:00;10:58:01");
        assertThat(list, is(listExpect));
    }
}