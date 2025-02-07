package ru.itmo.prog.lab5.object;

import ru.itmo.prog.lab5.utils.Element;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Класс фильма
 *
 * @author ldpst
 */
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
     *
     * @param other объект типа Element для сравнения
     * @return int
     */
    @Override
    public int compareTo(Element other) {
        return Long.compare(getId(), other.getId());
    }

    /**
     * Метод, возвращающий значение поля id
     *
     * @return int
     */
    @Override
    public long getId() {
        return this.id;
    }

    /**
     * Метод проверки валидности полей класса
     *
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

    /**
     * Метод, возвращающий значение поля name
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Метод, возвращающий значение поля coordinates
     *
     * @return Coordinates
     */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    /**
     * Метод, возвращающий значение поля creationDate
     *
     * @return ZonedDateTime
     */
    public java.time.ZonedDateTime getCreationDate() {
        return this.creationDate;
    }

    /**
     * Метод, возвращающий значение поля oscarsCount
     *
     * @return Long
     */
    public Long getOscarsCount() {
        return this.oscarsCount;
    }

    /**
     * Метод, возвращающий значение поля genre
     *
     * @return MovieGenre
     */
    public MovieGenre getGenre() {
        return this.genre;
    }

    /**
     * Метод, возвращающий значение поля mpaaRating
     *
     * @return MpaaRating
     */
    public MpaaRating getMpaaRating() {
        return this.mpaaRating;
    }

    /**
     * Метод, возвращающий значение operator
     *
     * @return Person
     */
    public Person getOperator() {
        return this.operator;
    }

    /**
     * Метод для сравнения двух элементов Movie
     *
     * @param o объект для сравнения
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return (this.id == movie.getId() &&
                Objects.equals(this.name, movie.getName()) &&
                Objects.equals(this.coordinates, movie.getCoordinates()) &&
                Objects.equals(this.creationDate, movie.getCreationDate()) &&
                Objects.equals(this.oscarsCount, getOscarsCount()) &&
                Objects.equals(this.genre, getGenre()) &&
                Objects.equals(this.mpaaRating, getMpaaRating()) &&
                Objects.equals(this.operator, movie.getOperator()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.coordinates, this.creationDate, this.oscarsCount, this.genre, this.mpaaRating, this.operator);
    }

    @Override
    public String toString() {
        return "> Имя: " + this.name + "\n" +
                "> Координаты:\n" + this.coordinates.toString() + "\n" +
                "> Дата создания: " + this.creationDate.toString() + "\n" +
                "> Количество оскаров: " + this.oscarsCount.toString() + "\n" +
                "> Жанр: " + ((this.genre != null) ? (this.genre.toString() + "\n") : "null\n") +
                "> Мпаа Рейтинг: " + ((this.mpaaRating != null) ? (this.mpaaRating.toString() + "\n") : "null\n") +
                "> Оператор: " + ((this.operator != null) ? ("\n" + this.operator.toString()) : "null");
    }
}