package ru.itmo.prog.lab5.utils;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException() {
        super();
    }

    public ElementNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Element not found";
    }
}
