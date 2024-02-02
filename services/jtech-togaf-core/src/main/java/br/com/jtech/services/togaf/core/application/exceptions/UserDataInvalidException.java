package br.com.jtech.services.togaf.core.application.exceptions;

public class UserDataInvalidException extends RuntimeException {
    public UserDataInvalidException() {
    }

    public UserDataInvalidException(String message) {
        super(message);
    }

    public UserDataInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDataInvalidException(Throwable cause) {
        super(cause);
    }

    public UserDataInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
