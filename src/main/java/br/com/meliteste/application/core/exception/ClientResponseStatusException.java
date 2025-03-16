package br.com.meliteste.application.core.exception;

public class ClientResponseStatusException extends RuntimeException {

    private int status;

    public ClientResponseStatusException(int status, String message) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
};