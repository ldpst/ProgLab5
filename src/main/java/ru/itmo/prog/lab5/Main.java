package ru.itmo.prog.lab5;

import org.checkerframework.checker.units.qual.C;
import ru.itmo.prog.lab5.commands.Command;
import ru.itmo.prog.lab5.managers.CSVManager;
import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.Permissions;
import ru.itmo.prog.lab5.utils.Runner;
import ru.itmo.prog.lab5.utils.ScannerHandler;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScannerHandler scanner = new ScannerHandler(new Scanner(System.in));
        StreamHandler stream = new StreamHandler(System.out);
        Runner runner = new Runner(scanner, stream);
        CSVManager csvManager = new CSVManager(stream);
//        csvManager.loadFromCSV();
        runner.runInteractiveMode();
    }
}
