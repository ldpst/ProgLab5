package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.utils.ScannerHandler;
import ru.itmo.prog.lab5.utils.StreamHandler;
import ru.itmo.prog.lab5.utils.TryAganable;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

import static java.lang.System.exit;

public abstract class Builder implements TryAganable {
    protected StreamHandler stream;
    protected ScannerHandler scanner;
    protected final Lock lock = new ReentrantLock();
    protected int inputFormat = 1; // 1 - через консоль, 2 - через execute_script


    public Builder(StreamHandler stream, ScannerHandler scanner) {
        this.stream = stream;
        this.scanner = scanner;
    }

    public Builder(StreamHandler stream, ScannerHandler scanner, int inputFormat) {
        this.stream = stream;
        this.scanner = scanner;
        this.inputFormat = inputFormat;
    }


    /**
     * Метод для заполнения объекта данными, используя стандартный ввод
     *
     * @return Заполненный объект
     */
    abstract public Object build();

    /**
     * Метод для запроса повторного ввода
     *
     * @param action метод, который запустится повторно
     * @return Объект-результат переданной функции
     */
    public Object tryAgain(Supplier<Object> action) {
        if (inputFormat == 2) {
            exit(0);
        }
        stream.print("* Повторная попытка ввода\n");
        return action.get();
    }
}
