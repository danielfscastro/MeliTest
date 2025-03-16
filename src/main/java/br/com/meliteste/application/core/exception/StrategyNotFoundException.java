package br.com.meliteste.application.core.exception;

public class StrategyNotFoundException extends RuntimeException {

    public StrategyNotFoundException(String message) {
        super(message);
    }
}
