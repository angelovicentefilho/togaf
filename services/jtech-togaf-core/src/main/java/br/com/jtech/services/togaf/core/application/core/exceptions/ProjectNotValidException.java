package br.com.jtech.services.togaf.core.application.core.exceptions;

public class ProjectNotValidException extends RuntimeException {
    public ProjectNotValidException() {
    }

    public ProjectNotValidException(String message) {
        super(message);
    }

    public ProjectNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectNotValidException(Throwable cause) {
        super(cause);
    }

    public ProjectNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
