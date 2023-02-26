package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double summ = 0;
        List<Label> labels = averageScoreByPupil(pupils);
        for (Label label : labels) {
            summ += label.score();
        }
        return summ / labels.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averagePupilList = new ArrayList<>();
        double summ = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                summ += subject.score();
            }
            averagePupilList.add(new Label(pupil.name(), summ / pupil.subjects().size()));
            summ = 0;
        }
        return averagePupilList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjects = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (subjects.containsKey(subject.name())) {
                    subjects.put(subject.name(), subjects.get(subject.name()) + subject.score());
                } else {
                    subjects.put(subject.name(), subject.score());
                }
            }
        }
        List<Label> averageSubject = new ArrayList<>();
        double amont = pupils.size();
        for (Map.Entry<String, Integer> entry : subjects.entrySet()) {
            averageSubject.add(new Label(entry.getKey(), entry.getValue() / amont));
        }
        return averageSubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        SortedSet<Label> bestStudents = new TreeSet<>();
        double summ = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                summ += subject.score();
            }
            bestStudents.add(new Label(pupil.name(), summ));
            summ = 0;
        }
        return bestStudents.last();
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> mapSubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!mapSubject.containsKey(subject.name())) {
                    mapSubject.put(subject.name(), subject.score());
                } else {
                    mapSubject.put(subject.name(), mapSubject.get(subject.name()) + subject.score());
                }
            }
        }
        TreeSet<Label> bestSubjects = new TreeSet<>();
        for (Map.Entry<String, Integer> entry : mapSubject.entrySet()) {
            bestSubjects.add(new Label(entry.getKey(), entry.getValue()));
        }

        return bestSubjects.last();
    }
}