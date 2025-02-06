package ru.itmo.prog.lab5.object;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле может быть null
    private long weight; //Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 25, Строка не может быть пустой, Поле не может быть null
}