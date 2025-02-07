package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.object.Movie;
import ru.itmo.prog.lab5.object.MovieGenre;
import ru.itmo.prog.lab5.object.MpaaRating;
import ru.itmo.prog.lab5.object.builders.MovieBuilder;

import java.io.Console;
import java.io.PrintStream;
import java.util.Scanner;

public class Add extends Command {
    private CollectionManager collectionManager;
    private PrintStream errorStream;

    public Add(PrintStream stream, PrintStream errorStream, CommandManager commandManager) {
        super("add", "добавить новый элемент в коллекцию", stream, commandManager);
        this.errorStream = errorStream;
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        MovieBuilder movieBuilder = new MovieBuilder(stream, errorStream, commandManager.getScanner());
        Movie movie = movieBuilder.build();
        collectionManager.add(movie);
        System.out.println(movie.toString());
    }
}
