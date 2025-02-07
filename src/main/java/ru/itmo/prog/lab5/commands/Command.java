package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.StreamHandler;
import ru.itmo.prog.lab5.utils.Runable;

/**
 * Класс команда
 * @author ldpst
 */
public abstract class Command implements Runable {
    private final String name;
    private final String description;
    protected final StreamHandler stream;
    protected final CommandManager commandManager;

    public Command(String commandName, String description, StreamHandler stream, CommandManager commandManager) {
        this.name = commandName;
        this.description = description;
        this.stream = stream;
        this.commandManager = commandManager;
    }

    /**
     * Метод, возвращающий название команды
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Метод, возвращающий описание команды
     * @return String
     */
    public String getDescription() {
        return description;
    }
}
