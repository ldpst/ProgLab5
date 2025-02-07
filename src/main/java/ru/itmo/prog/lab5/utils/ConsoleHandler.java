package ru.itmo.prog.lab5.utils;


import java.io.PrintStream;

public class ConsoleHandler {
    private PrintStream stream;

    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";

    public ConsoleHandler(PrintStream stream) {
        this.stream = stream;
    }

    public void printErr(String msg) {
        print(RED + msg + RESET);
    }

    public void print(String msg) {
        stream.print(msg);
    }

    public void printSuccess(String msg) {
        print(GREEN + msg + RESET);
    }
}
