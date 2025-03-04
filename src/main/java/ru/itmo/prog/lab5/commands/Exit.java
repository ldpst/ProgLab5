package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.RunMode;
import ru.itmo.prog.lab5.utils.StreamHandler;

public class Exit extends Command {

    public Exit(CommandManager commandManager) {
        super("exit", "завершить программу (без сохранения в файл)", commandManager);
        collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        stream.printSuccess("Программа успешно завершена\n");
        commandManager.getRunner().setRunMode(RunMode.EXIT);
    }
}
