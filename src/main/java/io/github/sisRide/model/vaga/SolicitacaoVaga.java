package io.github.sisRide.model.vaga;

import java.util.Objects;

public class SolicitacaoVaga {

    private String emailPassageiro;
    private int idViagem;

    public SolicitacaoVaga() {

    }

    public SolicitacaoVaga(String emailPassageiro, int idViagem) {

        this.emailPassageiro = emailPassageiro;
        this.idViagem = idViagem;
    }

    public String getEmailPassageiro() {
        return emailPassageiro;
    }

    public void setEmailPassageiro(String emailPassageiro) {
        this.emailPassageiro = emailPassageiro;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitacaoVaga that = (SolicitacaoVaga) o;
        return getIdViagem() == that.getIdViagem() &&
                Objects.equals(getEmailPassageiro(), that.getEmailPassageiro());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmailPassageiro(), getIdViagem());
    }

    @Override
    public String toString() {

        return "SolicitacaoVaga{" +
                "emailPassageiro='" + emailPassageiro + '\'' +
                ", idViagem=" + idViagem +
                '}';
    }
}
