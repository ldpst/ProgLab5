package ru.itmo.prog.lab5.object;

import java.lang.annotation.Inherited;

/**
 * Класс жанра фильма
 * @author ldpst
 */
public enum MovieGenre {
    DRAMA,
    MUSICAL,
    HORROR;

    public static MovieGenre checkOf(String s) {
        return MovieGenre.valueOf(s.toUpperCase());
    }
}