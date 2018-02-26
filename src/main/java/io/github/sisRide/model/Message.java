package io.github.sisRide.model;

import java.util.Objects;

public class Message {

    private int id;
    private String emailEmissor;
    private String emailDestinatario;
    private String menssagem;

    public Message() {

    }

    public Message(int id, String emailEmissor, String emailDestinatario, String menssagem) {

        this.id = id;
        this.emailEmissor = emailEmissor;
        this.emailDestinatario = emailDestinatario;
        this.menssagem = menssagem;
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

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return getId() == message.getId() &&
                Objects.equals(getEmailEmissor(), message.getEmailEmissor()) &&
                Objects.equals(getEmailDestinatario(), message.getEmailDestinatario()) &&
                Objects.equals(getMenssagem(), message.getMenssagem());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getEmailEmissor(), getEmailDestinatario(), getMenssagem());
    }

    @Override
    public String toString() {
        
        return "Message{" +
                "id=" + id +
                ", emailEmissor='" + emailEmissor + '\'' +
                ", emailDestinatario='" + emailDestinatario + '\'' +
                ", menssagem='" + menssagem + '\'' +
                '}';
    }
}
