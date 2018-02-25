package io.github.sisRide.model;

import java.util.Objects;

public class Lugar {

    private int place_id;
    private String descricao;
    private String nome;
    private float lat;
    private float lng;
    private String emailUsuario;

    public Lugar() {

    }

    public Lugar(int place_id, String descricao, String nome, float lat, float lng, String emailUsuario) {

        this.place_id = place_id;
        this.descricao = descricao;
        this.nome = nome;
        this.lat = lat;
        this.lng = lng;
        this.emailUsuario = emailUsuario;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lugar lugar = (Lugar) o;
        return getPlace_id() == lugar.getPlace_id() &&
                Float.compare(lugar.getLat(), getLat()) == 0 &&
                Float.compare(lugar.getLng(), getLng()) == 0 &&
                Objects.equals(getDescricao(), lugar.getDescricao()) &&
                Objects.equals(getNome(), lugar.getNome()) &&
                Objects.equals(getEmailUsuario(), lugar.getEmailUsuario());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPlace_id(), getDescricao(), getNome(), getLat(), getLng(), getEmailUsuario());
    }

    @Override
    public String toString() {

        return "Lugar{" +
                "place_id=" + place_id +
                ", descricao='" + descricao + '\'' +
                ", nome='" + nome + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", emailUsuario='" + emailUsuario + '\'' +
                '}';
    }
}
