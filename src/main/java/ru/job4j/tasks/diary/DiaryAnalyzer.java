package ru.job4j.tasks.diary;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс, представляющий запись в дневнике студента.
 */
record DiaryEntry(LocalDate date, String time) {

}
/**
 * Класс, представляющий учебную сессию.
 */
record StudySession(int days, LocalDate startDate, LocalDate endDate)
        implements Comparable<StudySession> {

    @Override
    public int compareTo(StudySession o) {
        if (days == o.days) {
            return -startDate.compareTo(o.startDate);
        }
        return -Integer.compare(days, o.days);
    }
}

/**
 * Класс для анализа дневника и получения статистики по учебным сессиям.
 */
public class DiaryAnalyzer {

    /**
     * Метод для получения списка учебных сессий.
     *
     * @param entries Список записей из дневника.
     * @return Список учебных сессий, отсортированных по количеству дней.
     */
    public List<StudySession> getStudySessions(List<DiaryEntry> entries) {
        List<StudySession> sessions = new ArrayList<>();
        LocalDate prevDate = null;
        LocalDate startDate;
        int iter = -1;

        entries = entries.stream()
                .sorted(Comparator.comparing(DiaryEntry::date))
                .collect(Collectors.toList());

        for (DiaryEntry recDiary : entries) {
            if (prevDate == null) {
                sessions.add(new StudySession(0, recDiary.date(), null));
                iter++;
            } else if (daysBetweenInclusive(recDiary.date(), prevDate) > 1) {
                startDate = sessions.get(0).startDate();
                sessions.set(iter, new StudySession(daysBetweenInclusive(prevDate, startDate) + 1,
                        startDate, prevDate));

                sessions.add(new StudySession(0, recDiary.date(), null));
                iter++;
            }
            prevDate = recDiary.date();
        }
        if (sessions.size() > 0) {
            startDate = sessions.get(iter).startDate();
            sessions.set(iter, new StudySession(daysBetweenInclusive(prevDate, startDate) + 1,
                    startDate, prevDate));
        }
        return sessions;
    }

    public static int daysBetweenInclusive(LocalDate ld1, LocalDate ld2) {
        return (int) (Math.abs(ChronoUnit.DAYS.between(ld1, ld2)));
    }
}