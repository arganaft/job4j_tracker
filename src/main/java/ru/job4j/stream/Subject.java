package ru.job4j.stream;

/**
 * Класс типа record представляет модель школьного предмета, используется
 * в классе Pupil, в списке предметов ученика
 * @see Pupil
 * @param name Имя предмета
 * @param score Балл по предмету
 */
public record Subject(String name, int score) {
}
