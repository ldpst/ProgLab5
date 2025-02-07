package ru.itmo.prog.lab5.managers;

import ru.itmo.prog.lab5.commands.*;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класс для управления командами
 *
 * @author ldpst
 */
public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();
    private final CollectionManager collectionManager = new CollectionManager();
    private final Scanner scanner;

    public CommandManager(Console console, Scanner scanner) {
        this.scanner = scanner;
        addCommand("help", new Help(console, this));
        addCommand("info", new Info(console, this));
        addCommand("show", new Show(console, this));
        addCommand("add", new Add(console, this));
    }

    /**
     * Метод для добавления команды в commands
     *
     * @param commandName название команды
     * @param command     команда
     */
    public void addCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * Метод, возвращающий словарь команд
     *
     * @return Map[String, Command]
     */
    public Map<String, Command> getCommands() {
        return commands;
    }

    /**
     * Метод, возвращающий CollectionManager
     *
     * @return CollectionManager
     */
    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    /**
     * Метод, возвращающий Scanner
     *
     * @return Scanner
     */
    public Scanner getScanner() {
        return scanner;
    }
}
