package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.object.Movie;
import ru.itmo.prog.lab5.object.MovieGenre;
import ru.itmo.prog.lab5.object.MpaaRating;
import ru.itmo.prog.lab5.object.builders.MovieBuilder;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.io.Console;
import java.io.PrintStream;
import java.util.Scanner;

public class Add extends Command {
    private final CollectionManager collectionManager;

    public Add(StreamHandler stream, CommandManager commandManager) {
        super("add {Movie}", "добавить новый элемент в коллекцию", stream, commandManager);
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        Movie movie = new MovieBuilder(stream, commandManager.getScanner(), commandManager.getInputFormat()).build();
        collectionManager.add(movie);
        stream.printSuccess("Объект успешно добавлен\n");
    }
}
