package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.object.Coordinates;

import java.io.PrintStream;
import java.util.Scanner;

public class CoordinatesBuilder extends Builder {
    public CoordinatesBuilder(PrintStream stream, PrintStream errorStream, Scanner scanner) {
        super(stream, errorStream, scanner);
    }

    @Override
    public Coordinates build() {
        return new Coordinates(
                readX(),
                readY());
    }

    /**
     * Метод для чтения координаты X
     * @return float
     */
    private float readX() {
        stream.print("> Введите координату x:\n$ ");
        String res = scanner.nextLine().trim();
        float x;
        try {
            x = Float.parseFloat(res);
        } catch (NumberFormatException e) {
            errorStream.println("Координата x должна быть целым или вещественным числом\n");
            throw new NumberFormatException();
        }
        return x;
    }

    /**
     * Метод для чтения координаты Y
     * @return int
     */
    private int readY() {
        stream.print("> Введите координату y:\n$ ");
        String res = scanner.nextLine().trim();
        int y;
        try {
            y = Integer.parseInt(res);
        } catch (NumberFormatException e) {
            errorStream.println("Координата y должна быть целым числом\n");
            throw new NumberFormatException();
        }
        return y;
    }
}
