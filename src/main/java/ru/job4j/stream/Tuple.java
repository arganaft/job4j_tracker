package ru.job4j.stream;

/**
 * Класс типа record представляет модель данных, который используется
 * в классе Analyze, для представления итогов расчетов
 * @see Analyze
 * @param name Имя ученика или предмета
 * @param score Баллы по предмету
 */
public record Tuple(String name, double score) {
}
