package ru.itmo.prog.lab5.commands;

/**
 * Класс команда
 * @author ldpst
 */
public abstract class Command implements Runnable {
    private final String name;
    private final String description;
    public Command(String commandName, String description) {
        this.name = commandName;
        this.description = description;
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
