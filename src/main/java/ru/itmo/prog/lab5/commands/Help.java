package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CommandManager;

import java.io.Console;
import java.util.Map;

/**
 * Класс команды "help"
 * @author ldpst
 */
public class Help extends Command {
    private final Console console;
    private final CommandManager commandManager;

    public Help(Console console, CommandManager commandManager) {
        super("help", "вывести справку по доступным командам");
        this.console = console;
        this.commandManager = commandManager;
    }

    @Override
    public void run(String[] args) {
        console.printf("Справка по доступным командам:\n");
        for (Command command : commandManager.getCommands().values()) {
            console.printf("\t%s : %s\n", command.getName(), command.getDescription());
        }
    }
}
