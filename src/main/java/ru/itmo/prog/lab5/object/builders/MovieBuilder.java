package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.object.*;
import ru.itmo.prog.lab5.utils.ScannerHandler;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.util.Arrays;
import java.util.function.Supplier;

import static java.lang.System.exit;

/**
 * Класс для создания объекта Movie
 *
 * @author ldpst
 */
public class MovieBuilder extends Builder {
    public MovieBuilder(StreamHandler stream, ScannerHandler scanner) {
        super(stream, scanner);
    }

    public MovieBuilder(StreamHandler stream, ScannerHandler scanner, int inputFormat) {
        super(stream, scanner, inputFormat);
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
     * @return Найденная строка
     */
    private String readName() {
        stream.print("> Введите название фильма:\n$ ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            stream.printErr("Название не должно быть пустым\n");
            return (String) tryAgain(this::readName);
//            throw new InputCantBeNullException();
        }
        return name;
    }

    /**
     * Метод для чтения координат
     *
     * @return Найденные координаты
     */
    private Coordinates readCoordinates() {
        stream.print("* Ввод координат\n");
        return new CoordinatesBuilder(stream, scanner, inputFormat).build();
    }

    /**
     * Метод для чтения количества оскаров
     *
     * @return Найденное количество
     */
    private Long readOscarCount() {
        stream.print("> Введите количество оскаров:\n$ ");
        String res = scanner.nextLine().trim();
        long count;
        try {
            count = Long.parseLong(res);
        } catch (NumberFormatException e) {
            stream.printErr("Количество оскаров должно быть целым числом\n");
            return (Long) tryAgain(this::readOscarCount);
//            throw new NumberFormatException();
        }
        if (count <= 0) {
            stream.printErr("Количество оскаров должно быть больше нуля\n");
            return (Long) tryAgain(this::readOscarCount);
//            throw new NumberFormatException();
        }
        return count;
    }

    /**
     * Метод для чтения жанра
     *
     * @return Найденный жанр
     */
    private MovieGenre readGenre() {
        stream.print("> Введите жанр " + Arrays.toString(MovieGenre.values()) + ":\n$ ");
        String res = scanner.nextLine().trim();
        if (res.isEmpty()) {
            return null;
        }
        MovieGenre genre;
        try {
            genre = MovieGenre.checkOf(res);
        } catch (IllegalArgumentException e) {
            stream.printErr("Введенный жанр не является одним из предложенных\n");
            return (MovieGenre) tryAgain(this::readGenre);
//            throw new InputCantBeNullException();
        }
        return genre;
    }

    /**
     * Метод для чтения Мпаа Рейтинга
     *
     * @return Найденный MpaaRating
     */
    private MpaaRating readMpaaRating() {
        stream.print("> Введите Мпаа Рейтинг " + Arrays.toString(MpaaRating.values()) + ":\n$ ");
        String res = scanner.nextLine().trim();
        if (res.isEmpty()) {
            return null;
        }
        MpaaRating rating;
        try {
            rating = MpaaRating.checkOf(res);
        } catch (IllegalArgumentException e) {
            stream.printErr("Введенный Мпаа рейтинг не является одним из предложенных\n");
            return (MpaaRating) tryAgain(this::readMpaaRating);
//            throw new InputCantBeNullException();
        }
        return rating;
    }

    /**
     * Метод для чтения человека
     *
     * @return Найденный Person
     */
    private Person readPerson() {
        stream.print("> Оператор != null? y/n ");
        String res = scanner.nextLine().trim().toLowerCase();
        if (res.equals("y")) {
            stream.print("* Ввод оператора\n");
            return new PersonBuilder(stream, scanner, inputFormat).build();
        }
        if (res.equals("n")) {
            return null;
        }
        return (Person) tryAgain(this::readPerson);
    }
}
