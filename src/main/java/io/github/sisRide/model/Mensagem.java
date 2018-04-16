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
public class Mensagem {
    
    private String tipo;
    private String messagem;
    
    public Mensagem(){
        
    }

    public Mensagem(String tipo, String messagem) {
        this.tipo = tipo;
        this.messagem = messagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }
    
    
}
