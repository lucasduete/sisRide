/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.model;

/**
 *
 * @author caio
 */
public class Solicitacao {
    
    private String fotoPerfil;
    private String nome;
    private String email;
    
    public Solicitacao(){
        
    }

    public Solicitacao(String fotoPerfil, String nome, String email) {
        this.fotoPerfil = fotoPerfil;
        this.nome = nome;
        this.email = email;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
