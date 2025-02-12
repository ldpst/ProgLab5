package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.Permissions;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.util.Map;

/**
 * Класс команды info
 *
 * @author ldpst
 */
public class Info extends Command {
    private final CollectionManager collectionManager;

    public Info(StreamHandler stream, CommandManager commandManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", stream, commandManager);
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        CommandManager adminCM = new CommandManager(stream, commandManager.getScanner(), commandManager.getRunner(), Permissions.ADMIN);
        stream.printSuccess("Информация о коллекции:\n");
        Map<String, Command> commands = adminCM.getCommands();
        commands.get("type").runWithPermission(null);
        commands.get("size").runWithPermission(null);
        commands.get("get_creation_time").runWithPermission(null);
        commands.get("head").runWithPermission(null);
        commands.get("tail").runWithPermission(null);
        commands.get("max").runWithPermission(null);
        commands.get("min").runWithPermission(null);
    }
}
