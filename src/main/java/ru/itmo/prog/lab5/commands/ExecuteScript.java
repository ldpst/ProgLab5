package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.ScannerHandler;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ExecuteScript extends Command {

    public ExecuteScript(StreamHandler stream, CommandManager commandManager) {
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме", stream, commandManager);
    }

    @Override
    public void run(String[] args) {
        if (args.length != 2) {
            stream.printErr("Неверный формат команды\n");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader("config/" + args[1] + ".txt"))) {
            CommandManager executeCommandManager = new CommandManager(stream, new ScannerHandler(br, stream), commandManager.getUserPermission(), 2);
            Map<String, Command> commands = executeCommandManager.getCommands();
            String nextCommand = br.readLine().trim();
            stream.printScriptLine(nextCommand + "\n");
            while (!nextCommand.equals("exit")) {
                String[] splitCommand = nextCommand.split(" ");
                try {
                    commands.get(splitCommand[0]).runWithPermission(splitCommand);
                } catch (Exception e) {
                    stream.printErr("Команда не распознана\n");
                    return;
                }
                stream.print("$ ");
                nextCommand = br.readLine().trim();
                stream.printScriptLine(nextCommand + "\n");
            }
        } catch (FileNotFoundException e) {
            stream.printErr("Файл со скриптом не найден\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
