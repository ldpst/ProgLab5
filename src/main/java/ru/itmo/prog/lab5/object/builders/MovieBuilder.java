package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.object.*;
import ru.itmo.prog.lab5.utils.NameCantBeNull;

import java.io.Console;
import java.util.Date;
import java.util.Scanner;

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
                new Coordinates((float) 12, 10), (long) 1, MovieGenre.DRAMA, MpaaRating.G, new Person("Alex", new Date(), 10, "45674"));
    }

    private String readName() {
        console.printf("> Введите имя:\n$ ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            throw new NameCantBeNull();
        }
        return name;
    }
}
