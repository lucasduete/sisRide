package io.github.sisRide.model;

import java.util.Objects;

public class Lugar {

    private int place_id;
    private String descricao;
    private String nome;
    private double lat;
    private double lng;
    private String emailUsuario;

    public Lugar() {

    }

    public Lugar(int place_id, String descricao, String nome, double lat, double lng, String emailUsuario) {

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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
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
                Double.compare(lugar.getLat(), getLat()) == 0 &&
                Double.compare(lugar.getLng(), getLng()) == 0 &&
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

        return "LugarDaoPostgres{" +
                "place_id=" + place_id +
                ", descricao='" + descricao + '\'' +
                ", nome='" + nome + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", emailUsuario='" + emailUsuario + '\'' +
                '}';
    }
}
