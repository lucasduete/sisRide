package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorMessage;
import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Message;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarListUsuarioCommand implements Command {
    
    private GerenciadorUsuario gerenciadorUsuario;
    private GerenciadorMessage gerenciadorMessage;
    private Message message;
    
    public BuscarListUsuarioCommand(){

        this.gerenciadorUsuario = new GerenciadorUsuario();
        this.gerenciadorMessage = new GerenciadorMessage();
        this.message = new Message();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
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
