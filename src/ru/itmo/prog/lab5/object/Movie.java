package ru.itmo.prog.lab5.object;

public class Movie {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long oscarsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private MovieGenre genre; //Поле может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person operator; //Поле может быть null
}