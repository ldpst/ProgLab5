package ru.itmo.prog.lab5.utils;

/**
 * Класс элемента
 * @author ldpst
 */
public abstract class Element implements Comparable<Element>, Validatable {
    public abstract long getId();
}
