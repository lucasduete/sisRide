/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorMessage;
import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Message;
import io.github.sisRide.model.MessageUsuario;
import io.github.sisRide.model.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caio
 */
public class BuscarListUsuarioCommand implements Command{
    
    private GerenciadorUsuario gerusu;
    private GerenciadorMessage germen;
    private Message men;
    
    public BuscarListUsuarioCommand(){
        
        this.germen = new GerenciadorMessage();
        this.men = new Message();
        this.gerusu = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        /*String email = req.getParameter("emailU");
        String search = req.getParameter("search");
        
        List<MessageUsuario> mensagem = null;
        
        MessageUsuario mens = new MessageUsuario();
        
        List<Message> message;
        
        message = germen.listar();
        
        for (Message message1 : message) {
            if(message1.getEmailEmissor().equals(email)){
                mens.setId(message1.getId());
                Usuario usua = gerusu.getUsuarioByEmail(message1.getEmailDestinatario());
                mens.setFotoPerfilDestinatario(usua.getFotoPerfil());
                mens.setNomeDestinatario(usua.getNome());
                mensagem.add(mens);
            }
        }
        
        List<MessageUsuario> mensagem2 = null;
        
        List<Usuario> usu = gerusu.listar();
        
        
        message = germen.listar();
        
        for (Message message1 : message) {
            if(message1.getEmailEmissor().equals(email)){
                mens.setId(message1.getId());
                Usuario usua = gerusu.getUsuarioByEmail(message1.getEmailDestinatario());
                mens.setFotoPerfilDestinatario(usua.getFotoPerfil());
                mens.setNomeDestinatario(usua.getNome());
                mensagem.add(mens);
            }
        }
        
        
        req.setAttribute("Mensagem", mensagem);
        
        req.setAttribute("Mensagem2", mensagem2);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("TelaMessagem.jsp");
        
        dispatcher.forward(req, res);*/
        
    }
    
}
