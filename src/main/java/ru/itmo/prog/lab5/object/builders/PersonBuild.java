package ru.itmo.prog.lab5.object.builders;

import ru.itmo.prog.lab5.object.Person;
import ru.itmo.prog.lab5.utils.InputCantBeNullException;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Supplier;

public class PersonBuild extends Builder {

    public PersonBuild(StreamHandler stream, Scanner scanner) {
        super(stream, scanner);
    }

    @Override
    public Person build() {
        return new Person(
                readName(),
                readBirthday(),
                readWeight(),
                readPassportID()
        );
    }

    /**
     * Метод для чтения имени
     *
     * @return Найденная строка
     */
    private String readName() {
        stream.print("> Введите имя человека:\n$ ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            stream.printErr("Имя не должно быть пустым\n");
            return (String) tryAgain(this::readName);
//            throw new InputCantBeNullException();
        }
        return name;
    }

    /**
     * Метод для чтения даты рождения по формату
     *
     * @return Найденная дата
     */
    private Date readBirthday() {
        String format = "dd:MM:yyyy";
        stream.printf("> Введите дату рождения человека (формата %s):\n$ ", format);
        String res = scanner.nextLine().trim();
        if (res.isEmpty()) {
            stream.printErr("Дата рождения не должна быть пуста\n");
            return (Date) tryAgain(this::readBirthday);
//            throw new InputCantBeNullException();
        }
        String[] split = res.split(":");
        if (split.length != 3) {
            stream.printErr("Введенные данные неверного формата\n");
            return (Date) tryAgain(this::readBirthday);
        }
        if (split[0].length() != 2 || split[1].length() != 2 || split[2].length() != 4) {
            stream.printErr("Введенные данные неверного формата\n");
            return (Date) tryAgain(this::readBirthday);
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date;
        try {
            date = dateFormat.parse(res);
        } catch (ParseException e) {
            stream.printErr("Введенные данные неверного формата\n");
            return (Date) tryAgain(this::readBirthday);
//            throw new InputCantBeNullException();
        }
        return date;
    }

    /**
     * Метод для чтения веса
     *
     * @return Найденный вес
     */
    private long readWeight() {
        stream.print("> Введите вес человека:\n$ ");
        String res = scanner.nextLine().trim();
        if (res.isEmpty()) {
            stream.printErr("Вес не должен быть пустым\n");
            return (long) tryAgain(this::readWeight);
        }
        long weight;
        try {
            weight = Long.parseLong(res);
        } catch (NumberFormatException e) {
            stream.printErr("Вес должен быть целым числом\n");
            return (long) tryAgain(this::readWeight);
        }
        if (weight <= 0) {
            stream.printErr("Вес должен быть больше 0\n");
            return (long) tryAgain(this::readWeight);
        }
        return weight;
    }

    /**
     * Метод для паспорт айди
     *
     * @return Найденный паспорт айди
     */
    private String readPassportID() {
        stream.print("> Введите паспорт айди:\n$ ");
        String passportID = scanner.nextLine().trim();
        if (passportID.isEmpty()) {
            stream.printErr("Паспорт айди не может быть пустым\n");
            return (String) tryAgain(this::readPassportID);
        }
        if (!passportID.matches("\\d+")) {
            stream.printErr("Паспорт айди должен состоять только из цифр\n");
            return (String) tryAgain(this::readPassportID);
        }
        if (passportID.length() > 25) {
            stream.printErr("Паспорт айди не должен быть больше 25 символов\n");
            return (String) tryAgain(this::readPassportID);
        }
        return passportID;
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
