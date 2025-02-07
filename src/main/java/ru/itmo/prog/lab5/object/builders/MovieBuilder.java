package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.object.*;
import ru.itmo.prog.lab5.utils.NameCantBeNull;

import java.io.Console;
import java.util.Date;
import java.util.Scanner;

/**
 * Класс для создания объекта Movie
 *
 * @author ldpst
 */
public class MovieBuilder extends Builder {
    private final Console console;
    private final Scanner scanner;

    public MovieBuilder(Console console, Scanner scanner) {
        this.console = console;
        this.scanner = scanner;
    }

    @Override
    public Movie build() {
        return new Movie(
                readName(),
                readCoordinates(),
                (long) 1, MovieGenre.DRAMA, MpaaRating.G, new Person("Alex", new Date(), 10, "45674"));
    }

    /**
     * Метод для чтения имени
     * @return String считанное имя
     */
    private String readName() {
        console.printf("> Введите имя:\n$ ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            throw new NameCantBeNull();
        }
        return name;
    }

    private Coordinates readCoordinates() {
        console.printf("* Ввод координат\n");
        console.printf("> Введите координату x:\n$ ");
        String res = scanner.nextLine().trim();
        Float x;
        try {
            x = Float.parseFloat(res);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return new Coordinates(x, 10);
    }
}
