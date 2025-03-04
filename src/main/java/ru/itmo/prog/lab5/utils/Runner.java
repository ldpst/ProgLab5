package ru.itmo.prog.lab5.utils;

import ru.itmo.prog.lab5.commands.Command;
import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

public class Runner {
    private final CollectionManager collectionManager;

    private final ScannerHandler scanner;
    private final StreamHandler stream;
    private final CommandManager commandManager;
    private final Map<String, Command> commands;

    private InputFormat inputFormat;
    private InputFormat oldInputFormat;
    private RunMode runMode = RunMode.RUN;

    public static ArrayList<String> usedScripts = new ArrayList<>();

    public Runner(StreamHandler stream, CollectionManager collectionManager, InputStream inputStream, InputFormat inputFormat) {
        this.collectionManager = collectionManager;
        this.stream = stream;
        this.inputFormat = inputFormat;
        oldInputFormat = this.stream.getInputFormat();
        this.stream.setInputFormat(inputFormat);
        scanner = new ScannerHandler(new InputStreamReader(inputStream));
        commandManager = new CommandManager(stream, scanner, this, collectionManager);
        commands = commandManager.getCommands();
    }

    /**
     * Запуск
     */
    public void run() {
        while (runMode == RunMode.RUN) {
            stream.print("$ ");
            String nextCommand = scanner.nextLine().trim();
            if (nextCommand.isEmpty()) {
                continue;
            }
            String[] splitCommand = nextCommand.split(" ");
            try {
                commands.get(splitCommand[0]).run(splitCommand);
            } catch (ValidationError e) {
                throw e;
            } catch (NullPointerException e) {
                stream.printErr("Команда не распознана\n");
            } catch (Exception e) {
                stream.printErr("Неопознанная ошибка\n");
                System.exit(0);
            }
        }
        this.stream.setInputFormat(oldInputFormat);
    }

    /**
     * Устанавливает режим запуска
     *
     * @param runMode режим
     */
    public void setRunMode(RunMode runMode) {
        this.runMode = runMode;
    }

    public InputFormat getInputFormat() {
        return inputFormat;
    }
}
