package io.github.sisRide.model;

import java.util.Objects;

public class Rating {

    private String emailUsuario;
    private String emailAvaliado;
    private int nota;

    public Rating() {

    }

    public Rating(String emailUsuario, String emailAvaliado, int nota) {

        this.emailUsuario = emailUsuario;
        this.emailAvaliado = emailAvaliado;
        this.nota = nota;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getEmailAvaliado() {
        return emailAvaliado;
    }

    public void setEmailAvaliado(String emailAvaliado) {
        this.emailAvaliado = emailAvaliado;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return getNota() == rating.getNota() &&
                Objects.equals(getEmailUsuario(), rating.getEmailUsuario()) &&
                Objects.equals(getEmailAvaliado(), rating.getEmailAvaliado());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmailUsuario(), getEmailAvaliado(), getNota());
    }

    @Override
    public String toString() {

        return "Rating{" +
                "emailUsuario='" + emailUsuario + '\'' +
                ", emailAvaliado='" + emailAvaliado + '\'' +
                ", nota=" + nota +
                '}';
    }
}
