package io.github.sisRide.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Viagem {

    private int id;
    private LocalDate data;
    private float valor;
    private int vagas;
    private LocalDateTime horario;
    private boolean transporteAnimal;
    private int nivelConversa;
    private boolean podeFumar;
    private String emailMotorista;
    private String placaCarro;
    private int idLocalSaida;
    private int idLocalDestino;

    {
        valor = 0;
        vagas = 4;
        transporteAnimal = false;
        nivelConversa = 3;
        podeFumar = false;
    }

    public Viagem() {

    }

    public Viagem(int id, LocalDate data, float valor, int vagas, LocalDateTime horario,
                  boolean transporteAnimal, int nivelConversa, boolean podeFumar, String emailMotorista,
                  String placaCarro, int idLocalSaida, int idLocalDestino) {

        this.id = id;
        this.data = data;
        this.valor = valor;
        this.vagas = vagas;
        this.horario = horario;
        this.transporteAnimal = transporteAnimal;
        this.nivelConversa = nivelConversa;
        this.podeFumar = podeFumar;
        this.emailMotorista = emailMotorista;
        this.placaCarro = placaCarro;
        this.idLocalSaida = idLocalSaida;
        this.idLocalDestino = idLocalDestino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public boolean getTransporteAnimal() {
        return transporteAnimal;
    }

    public void setTransporteAnimal(boolean transporteAnimal) {
        this.transporteAnimal = transporteAnimal;
    }

    public int getNivelConversa() {
        return nivelConversa;
    }

    public void setNivelConversa(int nivelConversa) {
        this.nivelConversa = nivelConversa;
    }

    public boolean getPodeFumar() {
        return podeFumar;
    }

    public void setPodeFumar(boolean podeFumar) {
        this.podeFumar = podeFumar;
    }

    public String getEmailMotorista() {
        return emailMotorista;
    }

    public void setEmailMotorista(String emailMotorista) {
        this.emailMotorista = emailMotorista;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public int getIdLocalSaida() {
        return idLocalSaida;
    }

    public void setIdLocalSaida(int idLocalSaida) {
        this.idLocalSaida = idLocalSaida;
    }

    public int getIdLocalDestino() {
        return idLocalDestino;
    }

    public void setIdLocalDestino(int idLocalDestino) {
        this.idLocalDestino = idLocalDestino;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viagem viagem = (Viagem) o;
        return getId() == viagem.getId() &&
                Float.compare(viagem.getValor(), getValor()) == 0 &&
                getVagas() == viagem.getVagas() &&
                getTransporteAnimal() == viagem.getTransporteAnimal() &&
                getNivelConversa() == viagem.getNivelConversa() &&
                getPodeFumar() == viagem.getPodeFumar() &&
                getIdLocalSaida() == viagem.getIdLocalSaida() &&
                getIdLocalDestino() == viagem.getIdLocalDestino() &&
                Objects.equals(getData(), viagem.getData()) &&
                Objects.equals(getHorario(), viagem.getHorario()) &&
                Objects.equals(getEmailMotorista(), viagem.getEmailMotorista()) &&
                Objects.equals(getPlacaCarro(), viagem.getPlacaCarro());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getData(), getValor(), getVagas(), getHorario(), getTransporteAnimal(), getNivelConversa(), getPodeFumar(), getEmailMotorista(), getPlacaCarro(), getIdLocalSaida(), getIdLocalDestino());
    }

    @Override
    public String toString() {

        return "Viagem{" +
                "id=" + id +
                ", data=" + data +
                ", valor=" + valor +
                ", vagas=" + vagas +
                ", horario=" + horario +
                ", transporteAnimal=" + transporteAnimal +
                ", nivelConversa=" + nivelConversa +
                ", podeFumar=" + podeFumar +
                ", emailMotorista='" + emailMotorista + '\'' +
                ", placaCarro='" + placaCarro + '\'' +
                ", idLocalSaida=" + idLocalSaida +
                ", idLocalDestino=" + idLocalDestino +
                '}';
    }
}
