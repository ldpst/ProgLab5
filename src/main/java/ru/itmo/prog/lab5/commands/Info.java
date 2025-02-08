package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.util.Map;

public class Info extends Command {
    private final CollectionManager collectionManager;

    public Info(StreamHandler stream, CommandManager commandManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", stream, commandManager);
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        CommandManager adminCM = new CommandManager(stream, commandManager.getScanner(), 1);
        stream.printSuccess("Информация о коллекции:\n");
        Map<String, Command> commands = adminCM.getCommands();
        commands.get("type").runWithPermission(null);
        commands.get("size").runWithPermission(null);
        stream.printSuccess("Время инициализации:\n");
        stream.printf("> %s\n", collectionManager.getCreationTime());
        commands.get("head").runWithPermission(null);
    }
}
