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
public class MessageUsuario {
    
    private String emailEmissor;
    private String emailDestinatario;
    private String nomeDestinatario;
    private String fotoPerfilDestinatario;
    
    public MessageUsuario(){
        
    }

    public MessageUsuario(String emailEmissor, String emailDestinatario, String nomeDestinatario, String fotoPerfilDestinatario) {
        this.emailEmissor = emailEmissor;
        this.emailDestinatario = emailDestinatario;
        this.nomeDestinatario = nomeDestinatario;
        this.fotoPerfilDestinatario = fotoPerfilDestinatario;
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

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getFotoPerfilDestinatario() {
        return fotoPerfilDestinatario;
    }

    public void setFotoPerfilDestinatario(String fotoPerfilDestinatario) {
        this.fotoPerfilDestinatario = fotoPerfilDestinatario;
    }
    
    

}