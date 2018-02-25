package io.github.sisRide.model;

import java.time.LocalDate;
import java.util.Objects;

public class Carro {

    private String placa;
    private String modelo;
    private boolean arCondicionado;
    private LocalDate ano;
    private String emailAdministrador;

    {
        arCondicionado = false;
    }

    public Carro() {

    }

    public Carro(String placa, String modelo, boolean arCondicionado,
                 LocalDate ano, String emailAdministrador) {

        this.placa = placa;
        this.modelo = modelo;
        this.arCondicionado = arCondicionado;
        this.ano = ano;
        this.emailAdministrador = emailAdministrador;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public LocalDate getAno() {
        return ano;
    }

    public void setAno(LocalDate ano) {
        this.ano = ano;
    }

    public String getEmailAdministrador() {
        return emailAdministrador;
    }

    public void setEmailAdministrador(String emailAdministrador) {
        this.emailAdministrador = emailAdministrador;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return isArCondicionado() == carro.isArCondicionado() &&
                Objects.equals(getPlaca(), carro.getPlaca()) &&
                Objects.equals(getModelo(), carro.getModelo()) &&
                Objects.equals(getAno(), carro.getAno()) &&
                Objects.equals(getEmailAdministrador(), carro.getEmailAdministrador());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPlaca(), getModelo(), isArCondicionado(), getAno(), getEmailAdministrador());
    }

    @Override
    public String toString() {

        return "Carro{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", arCondicionado=" + arCondicionado +
                ", ano=" + ano +
                ", emailAdministrador='" + emailAdministrador + '\'' +
                '}';
    }
}
