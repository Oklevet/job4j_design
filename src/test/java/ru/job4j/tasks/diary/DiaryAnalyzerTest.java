package ru.job4j.tasks.diary;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DiaryAnalyzerTest {

    @Test
    public void whenSingleSession() {
        List<DiaryEntry> entries = Arrays.asList(
                new DiaryEntry(LocalDate.of(2024, 12, 20), "09:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 21), "10:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 22), "11:00")
        );

        DiaryAnalyzer analyzer = new DiaryAnalyzer();
        List<StudySession> sessions = analyzer.getStudySessions(entries);

        assertThat(sessions, hasSize(1));
        StudySession session = sessions.get(0);
        assertThat(session.days(), is(3));
        assertThat(session.startDate(), is(LocalDate.of(2024, 12, 20)));
        assertThat(session.endDate(), is(LocalDate.of(2024, 12, 22)));
    }

    @Test
    public void whenMultipleSessions() {
        List<DiaryEntry> entries = Arrays.asList(
                new DiaryEntry(LocalDate.of(2024, 12, 20), "09:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 21), "10:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 22), "11:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 24), "09:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 25), "10:00")
        );

        DiaryAnalyzer analyzer = new DiaryAnalyzer();
        List<StudySession> sessions = analyzer.getStudySessions(entries);

        assertThat(sessions, hasSize(2));

        StudySession firstSession = sessions.get(0);
        assertThat(firstSession.days(), is(3));
        assertThat(firstSession.startDate(), is(LocalDate.of(2024, 12, 20)));
        assertThat(firstSession.endDate(), is(LocalDate.of(2024, 12, 22)));

        StudySession secondSession = sessions.get(1);
        assertThat(secondSession.days(), is(2));
        assertThat(secondSession.startDate(), is(LocalDate.of(2024, 12, 24)));
        assertThat(secondSession.endDate(), is(LocalDate.of(2024, 12, 25)));
    }

    @Test
    public void whenNonConsecutiveEntries() {
        List<DiaryEntry> entries = Arrays.asList(
                new DiaryEntry(LocalDate.of(2024, 12, 20), "09:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 22), "10:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 24), "11:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 25), "09:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 27), "10:00")
        );

        DiaryAnalyzer analyzer = new DiaryAnalyzer();
        List<StudySession> sessions = analyzer.getStudySessions(entries);

        assertThat(sessions, hasSize(4));
    }

    @Test
    public void whenNoEntries() {
        List<DiaryEntry> entries = Arrays.asList();

        DiaryAnalyzer analyzer = new DiaryAnalyzer();
        List<StudySession> sessions = analyzer.getStudySessions(entries);

        assertThat(sessions, is(empty()));
    }

    @Test
    public void whenSingleDayMultipleEntries() {
        List<DiaryEntry> entries = Arrays.asList(
                new DiaryEntry(LocalDate.of(2024, 12, 20), "09:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 20), "14:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 20), "18:00")
        );

        DiaryAnalyzer analyzer = new DiaryAnalyzer();
        List<StudySession> sessions = analyzer.getStudySessions(entries);

        assertThat(sessions, hasSize(1));
        StudySession session = sessions.get(0);
        assertThat(session.days(), is(1));
        assertThat(session.startDate(), is(LocalDate.of(2024, 12, 20)));
        assertThat(session.endDate(), is(LocalDate.of(2024, 12, 20)));
    }

    @Test
    public void whenEntriesOutOfOrder() {
        List<DiaryEntry> entries = Arrays.asList(
                new DiaryEntry(LocalDate.of(2024, 12, 25), "10:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 20), "09:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 22), "11:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 21), "10:00"),
                new DiaryEntry(LocalDate.of(2024, 12, 24), "09:00")
        );

        DiaryAnalyzer analyzer = new DiaryAnalyzer();
        List<StudySession> sessions = analyzer.getStudySessions(entries);

        assertThat(sessions, hasSize(2));

        StudySession firstSession = sessions.get(0);
        assertThat(firstSession.days(), is(3));
        assertThat(firstSession.startDate(), is(LocalDate.of(2024, 12, 20)));
        assertThat(firstSession.endDate(), is(LocalDate.of(2024, 12, 22)));

        StudySession secondSession = sessions.get(1);
        assertThat(secondSession.days(), is(2));
        assertThat(secondSession.startDate(), is(LocalDate.of(2024, 12, 24)));
        assertThat(secondSession.endDate(), is(LocalDate.of(2024, 12, 25)));
    }
}