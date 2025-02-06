package ru.itmo.prog.lab5.managers;

import ru.itmo.prog.lab5.commands.Command;
import ru.itmo.prog.lab5.commands.Help;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для управления командами
 * @author ldpst
 */
public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManager(Console console) {
        addCommand("help", new Help(console, this));
    }

    /**
     * Метод для добавления команды в commands
     * @param commandName название команды
     * @param command команда
     */
    public void addCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * Метод, возвращающий словарь команд
     * @return Map\<String, Command\>
     */
    public Map<String, Command> getCommands() {
        return commands;
    }
}
