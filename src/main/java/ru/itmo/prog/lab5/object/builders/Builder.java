package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.utils.StreamHandler;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Builder {
    protected StreamHandler stream;
    protected Scanner scanner;
    protected final Lock lock = new ReentrantLock();


    public Builder(StreamHandler stream, Scanner scanner) {
        this.stream = stream;
        this.scanner = scanner;
    }


    /**
     * Метод для заполнения объекта данными, используя стандартный ввод
     *
     * @return Заполненный объект
     */
    abstract public Object build();
}
