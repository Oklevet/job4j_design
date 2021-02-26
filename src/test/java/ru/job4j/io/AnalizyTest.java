package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    Analizy analizy = new Analizy();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void addFewWorking() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01;10:59:0111:01:02;11:02:02"));
    }

    @Test
    public void allNotWork() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("400 10:59:01");
            out.println("500 11:01:02");
            out.println("500 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01; still not working"));
    }

    @Test
    public void allWork() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:57:01");
            out.println("100 10:58:01");
            out.println("300 10:59:01");
            out.println("700 11:01:02");
            out.println("900 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is(""));
    }

    @Test
    public void firstNotWork() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("400 10:58:00");
            out.println("300 10:58:01");
            out.println("200 10:59:01");
            out.println("100 11:01:02");
            out.println("100 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:58:00;10:58:01"));
    }
}