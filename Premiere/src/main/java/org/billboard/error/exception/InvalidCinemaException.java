package org.billboard.error.exception;

public class InvalidCinemaException extends Exception{
    private final String message;
    public InvalidCinemaException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
