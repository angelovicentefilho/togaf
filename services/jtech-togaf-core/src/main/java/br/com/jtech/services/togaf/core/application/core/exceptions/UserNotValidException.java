package br.com.jtech.services.togaf.core.application.core.exceptions;

public class UserNotValidException extends RuntimeException {
    public UserNotValidException() {
    }

    public UserNotValidException(String message) {
        super(message);
    }

    public UserNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotValidException(Throwable cause) {
        super(cause);
    }

    public UserNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
