package ru.itmo.prog.lab5.object.builders;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class Builder {
    protected PrintStream stream;
    protected PrintStream errorStream;
    protected Scanner scanner;


    public Builder(PrintStream stream, PrintStream errorStream, Scanner scanner) {
        this.stream = stream;
        this.errorStream = errorStream;
        this.scanner = scanner;
    }

    abstract public Object build();
}
