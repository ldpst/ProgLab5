package ru.itmo.prog.lab5.managers;

import ru.itmo.prog.lab5.commands.*;
import ru.itmo.prog.lab5.utils.Permissions;
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
    private final CollectionManager collectionManager = new CollectionManager();
    private final ScannerHandler scanner;
    private final Permissions userPermission;
    private int inputFormat = 1;
    private final Runner runner;

    public CommandManager(StreamHandler stream, ScannerHandler scanner, Runner runner, Permissions userPermission) {
        this.scanner = scanner;
        this.userPermission = userPermission;
        this.runner = runner;
        addCommand("help", new Help(stream, this));
        addCommand("info", new Info(stream, this));
        addCommand("show", new Show(stream, this));
        addCommand("add", new Add(stream, this));
        addCommand("update", new Update(stream, this));
        addCommand("remove_by_id", new RemoveById(stream, this));
        addCommand("clear", new Clear(stream, this));
        addCommand("exit", new Exit(stream, this));
        addCommand("head", new Head(stream, this));
        addCommand("tail", new Tail(stream, this));
        addCommand("save", new Save(stream, this));
        addCommand("type", new Type(stream, this));
        addCommand("get_creation_time", new getCreationTime(stream, this));
        addCommand("size", new Size(stream, this));
        addCommand("max", new Max(stream, this));
        addCommand("min", new Min(stream, this));
        addCommand("execute_script", new ExecuteScript(stream, this));
        addCommand("add_if_max", new AddIfMax(stream, this));
        addCommand("remove_greater", new RemoveGreater(stream, this));
        addCommand("max_by_operator", new MaxByOperator(stream, this));
        addCommand("count_by_operator", new CountByOperator(stream, this));
        addCommand("count_less_than_genre", new CountLessThanGenre(stream, this));
    }

    public CommandManager(StreamHandler stream, ScannerHandler scanner, Runner runner, Permissions userPermission, int inputFormat) {
        this(stream, scanner, runner, userPermission);
        this.inputFormat = inputFormat;
    }

    /**
     * Метод, возвращающий поле inputFormat
     *
     * @return inputFormat
     */
    public int getInputFormat() {
        return inputFormat;
    }

    /**
     * Метод для добавления команды в commands
     *
     * @param commandName название команды
     * @param command     команда
     */
    public void addCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * Метод, возвращающий словарь команд
     *
     * @return словарь из названий и команд
     */
    public Map<String, Command> getCommands() {
        return commands;
    }

    /**
     * Метод, возвращающий поле collectionManager
     *
     * @return collectionManager
     */
    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    /**
     * Метод, возвращающий поле scanner
     *
     * @return scanner
     */
    public ScannerHandler getScanner() {
        return scanner;
    }

    /**
     * Метод, возвращающий поле userPermission
     *
     * @return userPermission
     */
    public Permissions getUserPermission() {
        return userPermission;
    }

    /**
     * Возвращает поле runner
     *
     * @return runner
     */
    public Runner getRunner() {
        return runner;
    }
}
