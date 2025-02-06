package ru.itmo.prog.lab5;

import ru.itmo.prog.lab5.commands.Command;
import ru.itmo.prog.lab5.managers.CommandManager;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager(System.console());
        Map<String, Command> commands = commandManager.getCommands();
        commands.get("help").run();
    }
}
