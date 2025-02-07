package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.object.Person;
import ru.itmo.prog.lab5.utils.InputCantBeNullException;

import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

public class PersonBuild extends Builder {

    public PersonBuild(PrintStream stream, PrintStream errorStream, Scanner scanner) {
        super(stream, errorStream, scanner);
    }

    @Override
    public Person build() {
        return new Person(
                readName(),
                new Date(),
                10,
                "12345"
                );
    }

    /**
     * Метод для чтения имени
     * @return String
     */
    private String readName() {
        stream.print("> Введите имя человека:\n$ ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            errorStream.println("Имя не должно быть пустым\n");
            throw new InputCantBeNullException();
        }
        return name;
    }
}
