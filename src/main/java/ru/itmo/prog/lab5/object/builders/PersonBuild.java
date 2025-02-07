package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.object.Person;
import ru.itmo.prog.lab5.utils.InputCantBeNullException;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                readBirthday(),
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
            errorStream.println("Имя не должно быть пустым");
            throw new InputCantBeNullException();
        }
        return name;
    }

    /**
     * Метод для чтения даты рождения
     * @return Date
     */
    private Date readBirthday() {
        stream.print("> Введите дату рождения человека (формата dd:mm:yyyy):\n$ ");
        String res = scanner.nextLine().trim();
        if (res.isEmpty()) {
            errorStream.println("Дата рождения не должна быть пуста");
            throw new InputCantBeNullException();
        }
        DateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        Date date;
        try {
            date = dateFormat.parse(res);
        } catch (ParseException e) {
            errorStream.println("Введенные данные неверного формата");
            throw new InputCantBeNullException();
        }
        return date;
    }

    private long readWeight() {
        stream.print("> Введите вес человека:");
        return 1;
    }
}
