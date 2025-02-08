package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.object.Movie;
import ru.itmo.prog.lab5.object.builders.IDBuilder;
import ru.itmo.prog.lab5.utils.StreamHandler;

public class RemoveById extends Command {
    private final CollectionManager collectionManager;

    public RemoveById(StreamHandler stream, CommandManager commandManager) {
        super("remove_by_id", "удалить элемент из коллекции по его id", stream, commandManager);
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        Long aimId = new IDBuilder(stream, commandManager.getScanner(), args).build();
        if (aimId == null) {
            return;
        }
        Movie aim = collectionManager.findElemById(aimId);
        if (aim == null) {
            stream.printErr("Объекта под данным id не существует\n");
            return;
        }
        collectionManager.remove(aim);
        stream.printSuccess("Объект под данным id успешно удален\n");
    }
}
