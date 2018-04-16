/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorMessage;
import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Mensagem;
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
public class NovaMensagemCommand implements Command{
    
    private GerenciadorUsuario gerusu;
    private GerenciadorMessage germen;
    private Message men;
    
    public NovaMensagemCommand(){
        
        this.germen = new GerenciadorMessage();
        this.men = new Message();
        this.gerusu = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        String emailE = req.getParameter("emailEmissor");
        String emailD = req.getParameter("emailDestinatario");
        String mensagem = req.getParameter("mensagem");
        
        men.setEmailDestinatario(emailD);
        men.setEmailEmissor(emailE);
        men.setMensagem(mensagem);
        
        germen.salvar(men);
        
        List<Usuario> usu = gerusu.listar();
        
        MessageUsuario mens2 = new MessageUsuario();
        
        List<MessageUsuario> mensagem2 = null;
        
        for (Usuario usu1 : usu) {
            mens2.setEmailEmissor(emailE);
            mens2.setEmailDestinatario(usu1.getEmail());
            mens2.setFotoPerfilDestinatario(usu1.getFotoPerfil());
            mens2.setNomeDestinatario(usu1.getNome());
        }
        
        List<Message> mens = germen.listar();
        
        List<Mensagem> mensagem3 = null;
        
        Mensagem mensagens = new Mensagem();
        
        for (Message mess : mens) {
            if((mess.getEmailEmissor().equals(emailE)) && (mess.getEmailDestinatario().equals(emailD))){
                mensagens.setTipo("sent");
                mensagens.setMessagem(mess.getMensagem());
                mensagem3.add(mensagens);
            }
            if((mess.getEmailDestinatario().equals(emailE)) && (mess.getEmailEmissor().equals(emailD))){
                mensagens.setTipo("replies");
                mensagens.setMessagem(mess.getMensagem());
                mensagem3.add(mensagens);
            }
            
        }
        
        req.setAttribute("Mensagem2", mensagem2);
        req.setAttribute("Mensagem3", mensagem3);
        req.setAttribute("emailEmissor", emailE);
        req.setAttribute("emailDestinatario", emailD);
        
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("TelaMessagem.jsp");
        
        dispatcher.forward(req, res);
        
    }
    
}
