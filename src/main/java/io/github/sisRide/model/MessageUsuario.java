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
    
    private int id;
    private String nomeDestinatario;
    private String fotoPerfilDestinatario;
    
    public MessageUsuario(){
        
    }

    public MessageUsuario(int id, String nomeDestinatario, String fotoPerfilDestinatario) {
        this.id = id;
        this.nomeDestinatario = nomeDestinatario;
        this.fotoPerfilDestinatario = fotoPerfilDestinatario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
