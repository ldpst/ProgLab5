package ru.itmo.prog.lab5.object;

import ru.itmo.prog.lab5.utils.Validatable;
import ru.itmo.prog.lab5.utils.ValidationError;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Класс координат
 *
 * @author ldpst
 */
public class Coordinates implements Validatable {
    private Float x; //Поле не может быть null
    private int y; //Значение поля должно быть больше -486

    public Coordinates(Float x, int y) {
        this.x = x;
        this.y = y;
        if (!isValid()) {
            throw new ValidationError("Coordinates");
        }
    }

    /**
     * Метод, возвращающий значение поля x
     *
     * @return x
     */
    public Float getX() {
        return x;
    }

    /**
     * Метод, возвращающий значение поля y
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Метод, возвращающий поля класса
     *
     * @return массив полей класса
     */
    public Field[] getField() {
        return this.getClass().getDeclaredFields();
    }

    @Override
    public boolean isValid() {
        if (x == null) return false;
        return y > -486;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Coordinates coordinates = (Coordinates) obj;
        return (Objects.equals(x, coordinates.getX()) && Objects.equals(y, coordinates.getY()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Координата x: " + x + "\nКоордината y: " + y;
    }
}