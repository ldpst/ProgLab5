package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.object.Movie;
import ru.itmo.prog.lab5.object.MovieGenre;
import ru.itmo.prog.lab5.object.MpaaRating;
import ru.itmo.prog.lab5.object.builders.MovieBuilder;

import java.io.Console;
import java.util.Scanner;

public class Add extends Command {
    private final Console console;
    private final CommandManager commandManager;
    private CollectionManager collectionManager;

    public Add(Console console, CommandManager commandManager) {
        super("add", "добавить новый элемент в коллекцию");
        this.console = console;
        this.commandManager = commandManager;
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        MovieBuilder movieBuilder = new MovieBuilder(console, commandManager.getScanner());
        Movie movie = movieBuilder.build();
        System.out.println(movie.toString());
    }
}
