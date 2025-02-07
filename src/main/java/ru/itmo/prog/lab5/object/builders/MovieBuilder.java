package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.object.*;
import ru.itmo.prog.lab5.utils.InputCantBeNullException;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Класс для создания объекта Movie
 *
 * @author ldpst
 */
public class MovieBuilder extends Builder {
    public MovieBuilder(PrintStream stream, PrintStream errorStream, Scanner scanner) {
        super(stream, errorStream, scanner);
    }

    @Override
    public Movie build() {
        return new Movie(
                readName(),
                readCoordinates(),
                readOscarCount(),
                readGenre(),
                readMpaaRating(),
                readPerson());
    }

    /**
     * Метод для чтения имени
     *
     * @return String
     */
    private String readName() {
        stream.print("> Введите имя:\n$ ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            errorStream.println("Имя не должно быть пустым\n");
            throw new InputCantBeNullException();
        }
        return name;
    }

    /**
     * Метод для чтения координат
     *
     * @return Coordinates
     */
    private Coordinates readCoordinates() {
        stream.print("* Ввод координат\n");
        return new CoordinatesBuilder(stream, errorStream, scanner).build();
    }

    /**
     * Метод для чтения количества оскаров
     *
     * @return long
     */
    private long readOscarCount() {
        stream.print("> Введите количество оскаров:\n$ ");
        String res = scanner.nextLine().trim();
        long count;
        try {
            count = Long.parseLong(res);
        } catch (NumberFormatException e) {
            errorStream.println("Количество оскаров должно быть целым числом\n");
            throw new NumberFormatException();
        }
        if (count <= 0) {
            errorStream.println("Количество оскаров должно быть больше нуля\n");
            throw new NumberFormatException();
        }
        return count;
    }

    /**
     * Метод для чтения жанра
     *
     * @return MovieGenre
     */
    private MovieGenre readGenre() {
        stream.print("> Введите жанр:\n$ ");
        String res = scanner.nextLine().trim();
        if (res.isEmpty()) {
            return null;
        }
        MovieGenre genre;
        try {
            genre = MovieGenre.checkOf(res);
        } catch (IllegalArgumentException e) {
            errorStream.println("Введенный жанр не является одним из предложенных\n");
            throw new InputCantBeNullException();
        }
        return genre;
    }

    /**
     * Метод для чтения Мпаа Рейтинга
     *
     * @return MpaaRating
     */
    private MpaaRating readMpaaRating() {
        stream.print("> Введите Мпаа Рейтинг:\n$ ");
        String res = scanner.nextLine().trim();
        if (res.isEmpty()) {
            return null;
        }
        MpaaRating rating;
        try {
            rating = MpaaRating.checkOf(res);
        } catch (IllegalArgumentException e) {
            errorStream.println("Введенный Мпаа рейтинг не является одним из предложенных\n");
            throw new InputCantBeNullException();
        }
        return rating;
    }

    /**
     * Метод для чтения человека
     *
     * @return Person
     */
    private Person readPerson() {
        stream.print("* Ввод человека\n");
        return new PersonBuild(stream, errorStream, scanner).build();
    }
}
