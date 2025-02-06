package ru.itmo.prog.lab5.object;

import java.util.Objects;

/**
 * Класс человек
 *
 * @author ldpst
 */
public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле может быть null
    private long weight; //Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 25, Строка не может быть пустой, Поле не может быть null

    /**
     * Метод, возвращающий значение поля name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Метод, возвращающий значение поля birthday
     *
     * @return Date
     */
    public java.util.Date getBirthday() {
        return birthday;
    }

    /**
     * Метод, возвращающий значение поля weight
     *
     * @return long
     */
    public long getWeight() {
        return weight;
    }

    /**
     * Метод, возвращающий значение поля passportID
     *
     * @return Date
     */
    public String getPassportID() {
        return passportID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return  (Objects.equals(name, person.getName()) &&
                Objects.equals(birthday, person.getBirthday()) &&
                Objects.equals(weight, person.getWeight()) &&
                Objects.equals(passportID, person.getPassportID()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, weight, passportID);
    }
}