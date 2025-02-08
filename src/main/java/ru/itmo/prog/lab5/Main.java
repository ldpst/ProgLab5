package ru.itmo.prog.lab5;

import ru.itmo.prog.lab5.commands.Command;
import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandManager commandManager = new CommandManager(new StreamHandler(System.out), scanner, 2);
        Map<String, Command> commands = commandManager.getCommands();
        String nextCommand = scanner.nextLine().trim();
        while (!nextCommand.equals("exit")) {
            String[] splitCommand = nextCommand.split(" ");
            commands.get(splitCommand[0]).run(splitCommand);
            nextCommand = scanner.nextLine();
        }
    }
}
