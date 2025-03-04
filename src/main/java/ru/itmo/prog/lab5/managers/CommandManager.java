package ru.itmo.prog.lab5.managers;

import ru.itmo.prog.lab5.commands.*;
import ru.itmo.prog.lab5.utils.InputFormat;
import ru.itmo.prog.lab5.utils.Runner;
import ru.itmo.prog.lab5.utils.ScannerHandler;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Класс для управления командами
 *
 * @author ldpst
 */
public class CommandManager {
    private final Map<String, Command> commands = new LinkedHashMap<>();

    private final StreamHandler stream;
    private final ScannerHandler scanner;
    private final Runner runner;
    private final CollectionManager collectionManager;

    public CommandManager(StreamHandler stream, ScannerHandler scanner, Runner runner, CollectionManager collectionManager) {
        this.stream = stream;
        this.scanner = scanner;
        this.runner = runner;
        this.collectionManager = collectionManager;

        addCommand("help", new Help(this));
        addCommand("info", new Info(this));
        addCommand("show", new Show( this));
        addCommand("add", new Add(this));
        addCommand("update", new Update( this));
        addCommand("remove_by_id", new RemoveById(this));
        addCommand("clear", new Clear(this));
        addCommand("exit", new Exit(this));
        addCommand("head", new Head(this));
        addCommand("save", new Save(this));
        addCommand("execute_script", new ExecuteScript(this));
        addCommand("add_if_max", new AddIfMax( this));
        addCommand("remove_greater", new RemoveGreater(this));
        addCommand("max_by_operator", new MaxByOperator(this));
        addCommand("count_by_operator", new CountByOperator(this));
        addCommand("count_less_than_genre", new CountLessThanGenre(this));
    }

    public void addCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public ScannerHandler getScanner() {
        return scanner;
    }

    public Runner getRunner() {
        return runner;
    }

    public StreamHandler getStream() {
        return stream;
    }
}
