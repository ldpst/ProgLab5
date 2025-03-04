package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CommandManager;

/**
 * Класс команды help
 *
 * @author ldpst
 */
public class Help extends Command {
    public Help(CommandManager commandManager) {
        super("help", "вывести справку по доступным командам", commandManager);
        collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        stream.printSuccess("Справка по доступным командам:\n");
        for (Command command : commandManager.getCommands().values()) {
            stream.printf("> %s : %s\n", command.getName(), command.getDescription());
        }
    }
}
