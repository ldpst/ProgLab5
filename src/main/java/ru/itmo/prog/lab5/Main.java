package ru.itmo.prog.lab5;

import ru.itmo.prog.lab5.managers.CollectionManager;
import ru.itmo.prog.lab5.utils.InputFormat;
import ru.itmo.prog.lab5.utils.Runner;
import ru.itmo.prog.lab5.utils.StreamHandler;

public class Main {
    public static void main(String[] args) {
        StreamHandler stream = new StreamHandler(System.out);
        CollectionManager collectionManager = new CollectionManager(stream);
        Runner runner = new Runner(stream, collectionManager, System.in, InputFormat.CONSOLE);
        runner.run();
    }
}
