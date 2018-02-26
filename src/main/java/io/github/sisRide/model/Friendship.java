package io.github.sisRide.model;

import java.util.Objects;

public class Friendship {

    private String emailUsuario;
    private String emailAmigo;

    public Friendship() {

    }

    public Friendship(String emailUsuario, String emailAmigo) {

        this.emailUsuario = emailUsuario;
        this.emailAmigo = emailAmigo;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getEmailAmigo() {
        return emailAmigo;
    }

    public void setEmailAmigo(String emailAmigo) {
        this.emailAmigo = emailAmigo;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friendship that = (Friendship) o;
        return Objects.equals(getEmailUsuario(), that.getEmailUsuario()) &&
                Objects.equals(getEmailAmigo(), that.getEmailAmigo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmailUsuario(), getEmailAmigo());
    }

    @Override
    public String toString() {

        return "Friendship{" +
                "emailUsuario='" + emailUsuario + '\'' +
                ", emailAmigo='" + emailAmigo + '\'' +
                '}';
    }
}
