package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CommandManager;

import java.util.Map;

/**
 * Класс команды info
 *
 * @author ldpst
 */
public class Info extends Command {
    public Info(CommandManager commandManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", commandManager);
        collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        stream.printSuccess("Информация о коллекции:\n");
        Map<String, Command> commands = commandManager.getCommands();

        stream.printSuccess("Тип коллекции:\n");
        stream.println("> " + collectionManager.getType().getName());

        stream.printSuccess("Размер коллекции:\n");
        stream.println("> " + collectionManager.getSize());stream.printSuccess("Размер коллекции:\n");
        stream.println("> " + collectionManager.getSize());

        stream.printSuccess("Время инициализации:\n");
        stream.printf("> %s\n", collectionManager.getCreationTime());

        commands.get("head").run(null);

        stream.printSuccess("Последний элемент коллекции:\n");
        if (collectionManager.isEmpty()) {
            stream.print("Коллекция пуста\n");
            return;
        }
        stream.print(collectionManager.getTail().toString() + "\n");

        stream.printSuccess("Максимальный элемент:\n");
        if (collectionManager.isEmpty()) {
            stream.print("Коллекция пуста\n");
            return;
        }
        stream.print(collectionManager.getMax().toString() + "\n");

        stream.printSuccess("Минимальный элемент:\n");
        if (collectionManager.isEmpty()) {
            stream.print("Коллекция пуста\n");
            return;
        }
        stream.print(collectionManager.getMin().toString() + "\n");
    }
}
