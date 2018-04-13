package io.github.sisRide.model;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {

    private String email;
    private String nome;
    private String senha;
    private float nota;
    private String fotoPerfil;
    private String sexo;
    private LocalDate dataNasc;
    private String profissao;
    private String cidade;
    private String tipo;

    {
        nota = 0;
    }

    public Usuario() {

    }

    public Usuario(String email, String nome, String senha, float nota, String fotoPerfil,
                   String sexo, LocalDate dataNasc, String profissao, String cidade, String tipo) {

        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.nota = nota;
        this.fotoPerfil = fotoPerfil;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.profissao = profissao;
        this.cidade = cidade;
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Float.compare(usuario.getNota(), getNota()) == 0 &&
                Objects.equals(getEmail(), usuario.getEmail()) &&
                Objects.equals(getNome(), usuario.getNome()) &&
                Objects.equals(getSenha(), usuario.getSenha()) &&
                Objects.equals(getFotoPerfil(), usuario.getFotoPerfil()) &&
                Objects.equals(getSexo(), usuario.getSexo()) &&
                Objects.equals(getDataNasc(), usuario.getDataNasc()) &&
                Objects.equals(getProfissao(), usuario.getProfissao()) &&
                Objects.equals(getCidade(), usuario.getCidade()) &&
                Objects.equals(getTipo(), usuario.getTipo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmail(), getNome(), getSenha(), getNota(), getFotoPerfil(), getSexo(), getDataNasc(), getProfissao(), getCidade(), getTipo());
    }

    @Override
    public String toString() {

        return "Usuario{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", nota=" + nota +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dataNasc=" + dataNasc +
                ", profissao='" + profissao + '\'' +
                ", cidade='" + cidade + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}
