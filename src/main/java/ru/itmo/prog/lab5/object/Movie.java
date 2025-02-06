package ru.itmo.prog.lab5.object;

import ru.itmo.prog.lab5.utils.Element;

import java.time.ZonedDateTime;

public class Movie extends Element {
    static long nextId = 1;

    private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long oscarsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private MovieGenre genre; //Поле может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person operator; //Поле может быть null

    public Movie(String name, Coordinates coordinates, Long oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person operator) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.operator = operator;
    }


    /**
     * Метод для сравнения с другим объектом Element
     * Результат меньше нуля, если other больше данного объекта. Результат равен нулю, если элементы равны. Результат больше нуля, если данный объект больше other
     * @param other объект типа Element для сравнения
     * @return int
     */
    @Override
    public int compareTo(Element other) {
        return Long.compare(getId(), other.getId());
    }

    /**
     * Метод, возвращающий значение поля id
     * @return int
     */
    @Override
    public long getId() {
        return this.id;
    }

    /**
     * Метод проверки валидности полей класса
     * @return boolean
     */
    @Override
    public boolean isValid() {
        if (this.id <= 0) return false;
        if (this.name == null || this.name.isEmpty()) return false;
        if (this.coordinates == null) return false;
        if (this.creationDate == null) return false;
        if (this.oscarsCount <= 0 || this.oscarsCount == null) return false;
        return true;
    }
}