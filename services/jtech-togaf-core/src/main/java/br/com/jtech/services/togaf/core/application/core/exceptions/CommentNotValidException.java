package br.com.jtech.services.togaf.core.application.core.exceptions;

public class CommentNotValidException extends RuntimeException {
    public CommentNotValidException() {
    }

    public CommentNotValidException(String message) {
        super(message);
    }

    public CommentNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommentNotValidException(Throwable cause) {
        super(cause);
    }

    public CommentNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
