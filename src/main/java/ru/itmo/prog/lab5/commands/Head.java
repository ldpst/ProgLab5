package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.StreamHandler;

public class Head extends Command {
    private final CollectionManager collectionManager;

    public Head(StreamHandler stream, CommandManager commandManager) {
        super("head", "вывести первый элемент коллекции", stream, commandManager);
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        if (collectionManager.isEmpty()) {
            stream.printSuccess("Коллекция пуста\n");
            return;
        }
        stream.printSuccess("Первый элемент коллекции:\n");
        stream.print(collectionManager.getHead().toString() + "\n");
    }
}
