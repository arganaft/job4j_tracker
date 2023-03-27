package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Вычисляет общий средний балл по всем
     * предмедметам всех учеников
     * @param stream На входе получает поток из списка учеников типа Pupil
     * @return Возвращает число типа double
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .map(Pupil::subjects)
                .flatMap(Collection::stream)
                .mapToDouble(Subject::score)
                .average()
                .orElse(0);
    }

    /**
     * Вычисляет средний балл по всем предметам каждого ученика
     * @param stream На входе получает поток из списка учеников типа Pupil
     * @return Возвращает список типов Tuple, каждый элемент которого
     * содержит имя ученика и среднее значение по всем его предметам
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(),
                        pupil.subjects().stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0)))
                .collect(Collectors.toList());
    }

    /**
     * Вычисляте средний балл по каждому предмету всех учеников
     * @param stream На входе получает поток из списка учеников типа Pupil
     * @return Возвращает список типов Tuple, каждый элемент которого
     * содержит имя предмета и среднее значение этого предмета по всех ученикам
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(Pupil::subjects)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new, Collectors.averagingDouble(Subject::score)))
                .entrySet().stream()
                .map(set -> new Tuple(set.getKey(), set.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Вычисляет лучшего стедента с наивысшим средним баллом
     * @param stream На входе получает поток из списка учеников типа Pupil
     * @return Возвращает ученика представленным в типе Tuple, который
     * содержит имя ученика и суммарное значение по всем его предметам
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }

    /**
     * Вычисляет лучший предмет с наивысшим средним баллом среди всех учеников
     * @param stream На входе получает поток из списка учеников типа Pupil
     * @return Возвращает предмет представленным в типе Tuple, который
     * содержит имя предмета и суммарное значение по всем его предметам
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .map(Pupil::subjects)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new, Collectors.summingDouble(Subject::score)))
                .entrySet().stream()
                .map(set -> new Tuple(set.getKey(), set.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }
}
