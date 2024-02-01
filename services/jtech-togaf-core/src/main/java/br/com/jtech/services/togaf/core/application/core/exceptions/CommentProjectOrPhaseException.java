package br.com.jtech.services.togaf.core.application.core.exceptions;

public class CommentProjectOrPhaseException extends RuntimeException {
    public CommentProjectOrPhaseException() {
    }

    public CommentProjectOrPhaseException(String message) {
        super(message);
    }

    public CommentProjectOrPhaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommentProjectOrPhaseException(Throwable cause) {
        super(cause);
    }

    public CommentProjectOrPhaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
