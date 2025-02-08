package ru.itmo.prog.lab5.object;

import ru.itmo.prog.lab5.utils.Validatable;
import ru.itmo.prog.lab5.utils.ValidationError;

import java.util.Objects;

/**
 * Класс человек
 *
 * @author ldpst
 */
public class Person implements Validatable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле может быть null
    private long weight; //Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 25, Строка не может быть пустой, Поле не может быть null

    public Person(String name, java.util.Date birthday, long weight, String passportID) {
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.passportID = passportID;
        if (!isValid()) {
            throw new ValidationError("Person");
        }
    }

    @Override
    public boolean isValid() {
        if (name == null) return false;
        if (birthday == null) return false;
        if (weight <= 0) return false;
        if (passportID == null || passportID.isEmpty() || passportID.length() > 25) return false;
        return true;
    }

    /**
     * Метод, возвращающий поле name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Метод, возвращающий поле birthday
     *
     * @return birthday
     */
    public java.util.Date getBirthday() {
        return birthday;
    }

    /**
     * Метод, возвращающий поле weight
     *
     * @return weight
     */
    public long getWeight() {
        return weight;
    }

    /**
     * Метод, возвращающий поле passportID
     *
     * @return passportID
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

    @Override
    public String toString() {
        return "Имя: " + this.name + "\nДень рождения: " + this.birthday.toString() + "\nВес: " + this.weight + "\nАйди паспорта: " + this.passportID;
    }
}