package ru.itmo.prog.lab5.utils;

public class InputCantBeNullException extends RuntimeException {
    public InputCantBeNullException() {
        super("Input cannot be null");
    }

    @Override
    public String getMessage() {
        return "Input cannot be null";
    }
}
