package ru.itmo.prog.lab5;

import ru.itmo.prog.lab5.commands.Command;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.ScannerHandler;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScannerHandler scanner = new ScannerHandler(new Scanner(System.in));
        StreamHandler stream = new StreamHandler(System.out);
        CommandManager commandManager = new CommandManager(stream, scanner, 2);
        Map<String, Command> commands = commandManager.getCommands();
        stream.print("$ ");
        String nextCommand = scanner.nextLine().trim();
        while (!nextCommand.equals("exit")) {
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
}
