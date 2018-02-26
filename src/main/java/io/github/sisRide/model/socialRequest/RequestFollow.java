package io.github.sisRide.model.socialRequest;

import java.util.Objects;

public class RequestFollow {

    private String emailUsuario;
    private String emailSeguidor;

    public RequestFollow() {

    }

    public RequestFollow(String emailUsuario, String emailSeguidor) {

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
        RequestFollow that = (RequestFollow) o;
        return Objects.equals(getEmailUsuario(), that.getEmailUsuario()) &&
                Objects.equals(getEmailSeguidor(), that.getEmailSeguidor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmailUsuario(), getEmailSeguidor());
    }

    @Override
    public String toString() {

        return "RequestFollowDaoPostgres{" +
                "emailUsuario='" + emailUsuario + '\'' +
                ", emailSeguidor='" + emailSeguidor + '\'' +
                '}';
    }
}
