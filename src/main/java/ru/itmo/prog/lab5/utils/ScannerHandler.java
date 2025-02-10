package ru.itmo.prog.lab5.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerHandler {
    private final Scanner scanner;
    private final BufferedReader reader;
    private final StreamHandler stream;

    public ScannerHandler(Scanner scanner) {
        this.scanner = scanner;
        this.reader = null;
        stream = null;
    }

    public ScannerHandler(BufferedReader reader, StreamHandler stream) {
        this.reader = reader;
        this.scanner = null;
        this.stream = stream;
    }

    public String nextLine() {
        if (scanner != null) {
            return scanner.nextLine();
        }
        if (reader != null) {
            try {
                String line = reader.readLine();
                if (stream != null) {
                    stream.printScriptLine(line + "\n");
                }
                return line;
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }
}
