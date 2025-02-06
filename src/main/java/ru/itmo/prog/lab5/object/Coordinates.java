package ru.itmo.prog.lab5.object;

import java.util.Objects;

/**
 * Класс координат
 *
 * @author ldpst
 */
public class Coordinates {
    private Float x; //Поле не может быть null
    private int y; //Значение поля должно быть больше -486

    /**
     * Метод, возвращающий значение поля x
     *
     * @return Float
     */
    public Float getX() {
        return x;
    }

    /**
     * Метод, возвращающий значение поля y
     *
     * @return int
     */
    public int getY() {
        return y;
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
}