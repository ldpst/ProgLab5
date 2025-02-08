package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.Runable;
import ru.itmo.prog.lab5.utils.StreamHandler;

/**
 * Класс команда
 *
 * @author ldpst
 */
public abstract class Command implements Runable {
    private final String name;
    private final String description;
    protected final StreamHandler stream;
    protected final CommandManager commandManager;
    protected final int permission; // 0 - super, 1 - admin, 2 - user

    public Command(String commandName, String description, StreamHandler stream, CommandManager commandManager, int permission) {
        this.name = commandName;
        this.description = description;
        this.stream = stream;
        this.commandManager = commandManager;
        this.permission = permission;
    }

    public Command(String commandName, String description, StreamHandler stream, CommandManager commandManager) {
        this(commandName, description, stream, commandManager, 2);
    }

    public void runWithPermission(String[] args) {
        if (permission < commandManager.getUserPermission()) {
            stream.printErr("Недостаточно прав для выполнения команды\n");
            return;
        }
        run(args);
    }

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

    /**
     * Метод, возвращающий необходимые права доступа
     *
     * @return permission
     */
    public int getPermission() {
        return permission;
    }
}
