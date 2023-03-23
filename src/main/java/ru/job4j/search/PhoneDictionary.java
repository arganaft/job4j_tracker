package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> phoneKey = person -> person.getPhone().contains(key);
        Predicate<Person> addressKey = person -> person.getAddress().contains(key);
        Predicate<Person> nameKey = person -> person.getName().contains(key);
        Predicate<Person> surnameKey = person -> person.getSurname().contains(key);
        Predicate<Person> combine = phoneKey.or(addressKey).or(nameKey).or(surnameKey);
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
