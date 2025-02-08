package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.object.Coordinates;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.util.Scanner;
import java.util.function.Supplier;

public class CoordinatesBuilder extends Builder {
    public CoordinatesBuilder(StreamHandler stream, Scanner scanner) {
        super(stream, scanner);
    }

    @Override
    public Coordinates build() {
        return new Coordinates(
                readX(),
                readY());
    }

    /**
     * Метод для чтения координаты X
     *
     * @return Найденное число
     */
    private Float readX() {
        stream.print("> Введите координату x:\n$ ");
        String res = scanner.nextLine().trim();
        float x;
        try {
            x = Float.parseFloat(res);
        } catch (NumberFormatException e) {
            stream.printErr("Координата x должна быть целым или вещественным числом\n");
            return (Float) tryAgain(this::readX);
//            throw new NumberFormatException();
        }
        return x;
    }

    /**
     * Метод для чтения координаты Y
     *
     * @return Найденное число
     */
    private int readY() {
        stream.print("> Введите координату y:\n$ ");
        String res = scanner.nextLine().trim();
        int y;
        try {
            y = Integer.parseInt(res);
        } catch (NumberFormatException e) {
            stream.printErr("Координата y должна быть целым числом\n");
            return (Integer) tryAgain(this::readY);
//            throw new NumberFormatException();
        }
        return y;
    }

    /**
     * Метод для запроса повторного ввода
     *
     * @param action метод, который запустится повторно
     * @return Объект-результат переданной функции
     */
    private Object tryAgain(Supplier<Object> action) {
        stream.print("* Повторная попытка ввода\n");
        return action.get();
    }
}
