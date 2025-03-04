package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.ScannerHandler;
import ru.itmo.prog.lab5.utils.StreamHandler;

/**
 * Класс команда
 *
 * @author ldpst
 */
public abstract class Command {
    private final String name;
    private final String description;
    protected final CommandManager commandManager;

    protected CollectionManager collectionManager;
    protected StreamHandler stream;
    protected ScannerHandler scanner;


    protected Command(String commandName, String description, CommandManager commandManager) {
        this.name = commandName;
        this.description = description;
        this.commandManager = commandManager;
        this.scanner = commandManager.getScanner();
        this.stream = commandManager.getStream();
    }

    /**
     * Метод для запуска команды с правами доступа
     *
     * @param args данные команды
     */
    public abstract void run(String[] args);

    /**
     * Метод, возвращающий название команды
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Метод, возвращающий описание команды
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }
}
