package ru.itmo.prog.lab5.utils;

public class NameCantBeNull extends RuntimeException {
    public NameCantBeNull() {
        super();
    }

    @Override
    public String getMessage() {
        return "Name cannot be null";
    }
}
