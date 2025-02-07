package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CommandManager;

import java.io.Console;
import java.io.PrintStream;
import java.util.Map;

/**
 * Класс команды "help"
 * @author ldpst
 */
public class Help extends Command {

    public Help(PrintStream stream, CommandManager commandManager) {
        super("help", "вывести справку по доступным командам", stream, commandManager);
    }

    @Override
    public void run(String[] args) {
        stream.printf("Справка по доступным командам:\n");
        for (Command command : commandManager.getCommands().values()) {
            stream.printf("\t%s : %s\n", command.getName(), command.getDescription());
        }
    }
}
