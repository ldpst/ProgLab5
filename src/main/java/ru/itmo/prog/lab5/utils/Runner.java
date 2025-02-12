package ru.itmo.prog.lab5.utils;

import ru.itmo.prog.lab5.commands.Command;
import ru.itmo.prog.lab5.managers.CommandManager;

import java.util.Map;
import java.util.Scanner;

public class Runner {
    private final ScannerHandler scanner;
    private final StreamHandler stream;
    private final CommandManager commandManager;
    private final Map<String, Command> commands;

    public RunMode runMode = RunMode.RUN;

    public Runner(ScannerHandler scanner, StreamHandler stream) {
        this.scanner = scanner;
        this.stream = stream;
        commandManager = new CommandManager(stream, scanner, this, Permissions.USER);
        commands = commandManager.getCommands();
    }

    public void runInteractiveMode() {
        stream.print("$ ");
        String nextCommand = scanner.nextLine().trim();
        while (runMode == RunMode.EXIT) {
            String[] splitCommand = nextCommand.split(" ");
            try {
                commands.get(splitCommand[0]).runWithPermission(splitCommand);
            } catch (Exception e) {
                stream.printErr("Команда не распознана\n");
            }
            stream.print("$ ");
            nextCommand = scanner.nextLine().trim();
        }
    }

    public void runScriptMode() {

    }

    public void setRunMode(RunMode runMode) {
        this.runMode = runMode;
    }
}
