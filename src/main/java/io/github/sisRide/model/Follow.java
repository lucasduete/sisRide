package io.github.sisRide.model;

import java.util.Objects;

public class Follow {

    private String emailUsuario;
    private String emailSeguidor;

    public Follow() {

    }

    public Follow(String emailUsuario, String emailSeguidor) {

        this.emailUsuario = emailUsuario;
        this.emailSeguidor = emailSeguidor;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getEmailSeguidor() {
        return emailSeguidor;
    }

    public void setEmailSeguidor(String emailSeguidor) {
        this.emailSeguidor = emailSeguidor;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return Objects.equals(getEmailUsuario(), follow.getEmailUsuario()) &&
                Objects.equals(getEmailSeguidor(), follow.getEmailSeguidor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmailUsuario(), getEmailSeguidor());
    }

    @Override
    public String toString() {

        return "Follow{" +
                "emailUsuario='" + emailUsuario + '\'' +
                ", emailSeguidor='" + emailSeguidor + '\'' +
                '}';
    }
}
