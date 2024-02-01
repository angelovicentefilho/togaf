package br.com.jtech.services.togaf.core.application.core.exceptions;

public class PhaseNotFoundException extends RuntimeException {
    public PhaseNotFoundException() {
    }

    public PhaseNotFoundException(String message) {
        super(message);
    }

    public PhaseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhaseNotFoundException(Throwable cause) {
        super(cause);
    }

    public PhaseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
