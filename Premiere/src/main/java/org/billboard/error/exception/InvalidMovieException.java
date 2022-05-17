package org.billboard.error.exception;

public class InvalidMovieException extends Exception{

    private final String message;

    public InvalidMovieException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
