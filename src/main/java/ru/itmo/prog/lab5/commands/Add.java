package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.object.Movie;
import ru.itmo.prog.lab5.object.builders.MovieBuilder;
import ru.itmo.prog.lab5.utils.StreamHandler;


/**
 * Класс команды add
 *
 * @author ldspt
 */
public class Add extends Command {
    public Add(CommandManager commandManager) {
        super("add {Movie}", "добавить новый элемент в коллекцию", commandManager);
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        Movie movie = new MovieBuilder(stream, commandManager.getScanner(), commandManager.getInputFormat()).build();
        collectionManager.add(movie);
        stream.printSuccess("Объект успешно добавлен\n");
    }
}
