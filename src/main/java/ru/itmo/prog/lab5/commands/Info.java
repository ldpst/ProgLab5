package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;

import java.io.Console;

public class Info extends Command {
    private final Console console;
    private final CommandManager commandManager;
    private CollectionManager collectionManager;

    public Info(Console console, CommandManager commandManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.console = console;
        this.commandManager = commandManager;
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        console.printf("Информация о коллекции:\n");
        console.printf("\tТип: %s\n", collectionManager.getCollectionClass());
        console.printf("\tРазмер: %s\n", collectionManager.getSize());
        console.printf("\tВремя инициализации: %s\n", collectionManager.getCreationTime());
    }
}
