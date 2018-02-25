package io.github.sisRide.model;

import java.util.Objects;

public class Follow {

    private String emailSeguidor;
    private String emailSeguindo;

    public Follow() {

    }

    public Follow(String emailSeguidor, String emailSeguindo) {

        this.emailSeguidor = emailSeguidor;
        this.emailSeguindo = emailSeguindo;
    }

    public String getEmailSeguidor() {
        return emailSeguidor;
    }

    public void setEmailSeguidor(String emailSeguidor) {
        this.emailSeguidor = emailSeguidor;
    }

    public String getEmailSeguindo() {
        return emailSeguindo;
    }

    public void setEmailSeguindo(String emailSeguindo) {
        this.emailSeguindo = emailSeguindo;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return Objects.equals(getEmailSeguidor(), follow.getEmailSeguidor()) &&
                Objects.equals(getEmailSeguindo(), follow.getEmailSeguindo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmailSeguidor(), getEmailSeguindo());
    }

    @Override
    public String toString() {
        return "Follow{" +
                "emailSeguidor='" + emailSeguidor + '\'' +
                ", emailSeguindo='" + emailSeguindo + '\'' +
                '}';
    }
}
