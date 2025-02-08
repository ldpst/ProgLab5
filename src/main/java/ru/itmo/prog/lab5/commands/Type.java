package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.StreamHandler;

public class Type extends Command {
    private final CollectionManager collectionManager;

    public Type(StreamHandler stream, CommandManager commandManager) {
        super("type", "вывести тип коллекции", stream, commandManager, 1);
        collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        stream.printSuccess("Тип коллекции:\n");
        stream.println("> " + collectionManager.getType().getName());
    }
}
