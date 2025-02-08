package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.object.Movie;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class Save extends Command {
    private final CollectionManager collectionManager;

    public Save(StreamHandler stream, CommandManager commandManager) {
        super("save", "сохранить коллекцию в файл", stream, commandManager);
        this.collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        String header = countFields(Movie.class, "");
        String filePath = System.getenv("Lab5FileName");
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write((header + "\n").getBytes());
            // ДОПИСАТЬ

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String countFields(Class<?> clazz, String prefix) {
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder res = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Class<?> type = field.getType();
                if (!field.getType().isPrimitive() && !field.getType().getName().startsWith("java.") && !field.getType().isEnum()) {
                    res.append(countFields(type, prefix + field.getName() + "."));
                } else {
                    res.append(prefix).append(field.getName()).append(",");
                }
            } catch (IllegalAccessError e) {
                continue;
            }
        }
        if (prefix.isEmpty()) {
            return res.substring(0, res.length() - 1);
        }
        return res.toString();
    }
}
