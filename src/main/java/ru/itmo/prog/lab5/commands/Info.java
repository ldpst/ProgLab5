package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.io.Console;
import java.io.PrintStream;

public class Info extends Command {
    private CollectionManager collectionManager;

    public Info(StreamHandler stream, CommandManager commandManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", stream, commandManager);
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        stream.printf("Информация о коллекции:\n");
        stream.printf("\tТип: %s\n", collectionManager.getCollectionClass());
        stream.printf("\tРазмер: %s\n", collectionManager.getSize());
        stream.printf("\tВремя инициализации: %s\n", collectionManager.getCreationTime());
    }
}
