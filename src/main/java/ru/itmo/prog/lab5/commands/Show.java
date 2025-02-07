package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.object.Movie;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.io.PrintStream;
import java.util.Deque;

public class Show extends Command {
    private CollectionManager collectionManager;

    public Show(StreamHandler stream, CommandManager commandManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении", stream, commandManager);
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        Deque<Movie> movies = collectionManager.getMovies();
        stream.printf("Элементы коллекции:\n");
        for (Movie movie : movies) {
            stream.printf("\n%s\n", movie.toString());
        }
    }
}
