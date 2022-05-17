package org.billboard.error.exception;

public class InvalidHallException extends Exception{
    private final String message;

    public InvalidHallException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
