package io.github.sisRide.model;

import java.util.Objects;

public class Message {

    private int id;
    private String emailEmissor;
    private String emailDestinatario;
    private String mensagem;

    public Message() {

    }

    public Message(int id, String emailEmissor, String emailDestinatario, String mensagem) {

        this.id = id;
        this.emailEmissor = emailEmissor;
        this.emailDestinatario = emailDestinatario;
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailEmissor() {
        return emailEmissor;
    }

    public void setEmailEmissor(String emailEmissor) {
        this.emailEmissor = emailEmissor;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
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
        Message message = (Message) o;
        return getId() == message.getId() &&
                Objects.equals(getEmailEmissor(), message.getEmailEmissor()) &&
                Objects.equals(getEmailDestinatario(), message.getEmailDestinatario()) &&
                Objects.equals(getMensagem(), message.getMensagem());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getEmailEmissor(), getEmailDestinatario(), getMensagem());
    }

    @Override
    public String toString() {

        return "Message{" +
                "id=" + id +
                ", emailEmissor='" + emailEmissor + '\'' +
                ", emailDestinatario='" + emailDestinatario + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
