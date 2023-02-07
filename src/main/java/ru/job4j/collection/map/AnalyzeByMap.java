package ru.job4j.collection.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0;
        double pupilScore = 0;

        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.getSubjects()) {
                pupilScore += subj.getScore();
            }
            sumScore += pupilScore / (double) pupil.getSubjects().size();
        }
        return sumScore / pupils.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double sumScore = 0;
        double pupilScore = 0;

        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.getSubjects()) {
                pupilScore += subj.getScore();
            }
            sumScore += pupilScore / (double) pupil.getSubjects().size();
            labels.add(new Label(pupil.getName(), sumScore));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Record> labels = new HashMap<>();
        List<Label> labelsList = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.getSubjects()) {
                labels.merge(subj.getName(), new Record(1, subj.getScore()),
                        (a, b) -> b = new Record(b.getSubjCount() + 1,
                        b.getScore() + subj.getScore()));
            }
        }

        for (Map.Entry<String, Record> label : labels.entrySet()) {
            labelsList.add(new Label(label.getKey(),
                    label.getValue().getScore() / label.getValue().getSubjCount()));
        }
        return labelsList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double sumScore = 0;
        double pupilScore = 0;

        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.getSubjects()) {
                pupilScore += subj.getScore();
            }
            sumScore += pupilScore / (double) pupil.getSubjects().size();
            labels.add(new Label(pupil.getName(), sumScore));
        }
        labels.sort((o1, o2) -> o2.compareTo(o1));
        return labels.get(0);
    }


    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> labels = new HashMap<>();
        LinkedHashMap bestSubj = null;
        String sKey = null;

        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.getSubjects()) {
                labels.merge(subj.getName(), subj.getScore(), (a, b) -> b += subj.getScore());
            }
        }

        List<Map.Entry<String, Integer>> listCompartor = new ArrayList<>(labels.entrySet());
        listCompartor.sort(Map.Entry.comparingByValue());
        bestSubj.put(listCompartor.get(listCompartor.size() - 1).getKey(),
                listCompartor.get(listCompartor.size() - 1).getValue());

        for (Object obj : bestSubj.keySet()) {
            sKey = (String) obj;
        }

        return new Label(sKey, labels.get(sKey));
    }

    /**
     * Вспомогательный класс для определения среднего значения по предметам
     */
    public static class Record implements Comparable<Record> {
        int subjCount;
        double score;

        public Record(int subjCount, double score) {
            this.subjCount = subjCount;
            this.score = score;
        }

        public int getSubjCount() {
            return subjCount;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public int compareTo(Record o) {
            return 0;
        }
    }
}
