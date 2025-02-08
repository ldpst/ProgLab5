package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.StreamHandler;

public class Size extends Command {
    private final CollectionManager collectionManager;

    public Size(StreamHandler stream, CommandManager commandManager) {
        super("size", "вывести размер коллекции", stream, commandManager, 1);
        collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        stream.printSuccess("Размер коллекции:\n");
        stream.println("> " + collectionManager.getSize());
    }
}
