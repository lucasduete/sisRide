package io.github.sisRide.model;

import java.time.LocalDate;
import java.util.Objects;

public class Carro {

    private String placa;
    private String modelo;
    private boolean arCondicionado;
    private LocalDate ano;
    private String emailProprieatario;

    {
        arCondicionado = false;
    }

    public Carro() {

    }

    public Carro(String placa, String modelo, boolean arCondicionado,
                 LocalDate ano, String emailProprieatario) {

        this.placa = placa;
        this.modelo = modelo;
        this.arCondicionado = arCondicionado;
        this.ano = ano;
        this.emailProprieatario = emailProprieatario;
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

    public boolean getArCondicionado() {
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

    public String getEmailProprieatario() {
        return emailProprieatario;
    }

    public void setEmailProprieatario(String emailProprieatario) {
        this.emailProprieatario = emailProprieatario;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return getArCondicionado() == carro.getArCondicionado() &&
                Objects.equals(getPlaca(), carro.getPlaca()) &&
                Objects.equals(getModelo(), carro.getModelo()) &&
                Objects.equals(getAno(), carro.getAno()) &&
                Objects.equals(getEmailProprieatario(), carro.getEmailProprieatario());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPlaca(), getModelo(), getArCondicionado(), getAno(), getEmailProprieatario());
    }

    @Override
    public String toString() {

        return "Carro{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", arCondicionado=" + arCondicionado +
                ", ano=" + ano +
                ", emailProprieatario='" + emailProprieatario + '\'' +
                '}';
    }
}
