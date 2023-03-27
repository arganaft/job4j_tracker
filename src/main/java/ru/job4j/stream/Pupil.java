package ru.job4j.stream;

import java.util.List;

/**
 * Класс типа record представляет модель Ученика, используется
 * в классе Analyze, для расчета статистики по ученикам и предметам
 * @see Analyze
 * @param name Имя Ученика
 * @param subjects Список его предметов
 */
public record Pupil(String name, List<Subject> subjects) {
}
