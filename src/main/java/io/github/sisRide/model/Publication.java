package io.github.sisRide.model;

import java.util.Objects;

public class Publication {

    private int id;
    private String emailUsuario;
    private int idLocal;
    private String mensagem;

    public Publication() {

    }

    public Publication(int id, String emailUsuario, int idLocal, String mensagem) {

        this.id = id;
        this.emailUsuario = emailUsuario;
        this.idLocal = idLocal;
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return getId() == that.getId() &&
                getIdLocal() == that.getIdLocal() &&
                Objects.equals(getEmailUsuario(), that.getEmailUsuario()) &&
                Objects.equals(getMensagem(), that.getMensagem());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getEmailUsuario(), getIdLocal(), getMensagem());
    }

    @Override
    public String toString() {

        return "Publication{" +
                "id=" + id +
                ", emailUsuario='" + emailUsuario + '\'' +
                ", idLocal=" + idLocal +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
