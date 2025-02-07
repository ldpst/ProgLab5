package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.object.Movie;

import java.io.Console;
import java.util.Deque;

public class Show extends Command {
    private final Console console;
    private final CommandManager commandManager;
    private CollectionManager collectionManager;

    public Show(Console console, CommandManager commandManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.console = console;
        this.commandManager = commandManager;
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        Deque<Movie> movies = collectionManager.getMovies();
        console.printf("Элементы коллекции:\n");
        for (Movie movie : movies) {
            console.printf("\n%s\n", movie.toString());
        }
    }
}
