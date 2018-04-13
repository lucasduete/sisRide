package io.github.sisRide.exceptions;

public class CredenciaisInvalidasException extends Exception {

    public CredenciaisInvalidasException() {
        super("Credenciais Invalidas, Nao e possivel fazer login.");
    }

    public CredenciaisInvalidasException(String msg) {
        super("Credenciais Invalidas, Nao e possivel fazer login, Motivo: " + msg);
    }
}
