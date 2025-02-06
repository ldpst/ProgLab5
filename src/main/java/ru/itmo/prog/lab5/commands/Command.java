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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
