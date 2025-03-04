package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.object.Movie;
import ru.itmo.prog.lab5.object.builders.MovieBuilder;

/**
 * Класс команды add_if_max
 *
 * @author ldpst
 */
public class AddIfMax extends Command {
    public AddIfMax(CommandManager commandManager) {
        super("add_if_max {element}", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции", commandManager);
        collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        Movie movie = new MovieBuilder(stream, commandManager.getScanner(), commandManager.getRunner().getInputFormat()).build();
        if (movie.compareTo(collectionManager.getMax()) > 0) {
            collectionManager.add(movie);
            stream.printSuccess("Элемент успешно добавлен\n");
        }
        else {
            stream.printSuccess("Элемент не был добавлен, так как он не больше максимального элемента в коллекции\n");
        }
    }
}
