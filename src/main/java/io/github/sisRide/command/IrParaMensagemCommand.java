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

public class IrParaMensagemCommand implements Command {
    
    private GerenciadorUsuario gerenciadorUsuario;
    private GerenciadorMessage gerenciadorMessage;
    private Message message;
    
    public IrParaMensagemCommand(){

        this.gerenciadorUsuario = new GerenciadorUsuario();
        this.gerenciadorMessage = new GerenciadorMessage();
        this.message = new Message();
    }
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        String emailE = request.getParameter("emailEmissor");
        String emailD = request.getParameter("emailDestinatario");
        
        List<Usuario> usu = gerenciadorUsuario.listar();
        
        MessageUsuario mens2 = new MessageUsuario();
        
        List<MessageUsuario> mensagem2 = null;
        
        for (Usuario usu1 : usu) {
            mens2.setEmailEmissor(emailE);
            mens2.setEmailDestinatario(usu1.getEmail());
            mens2.setFotoPerfilDestinatario(usu1.getFotoPerfil());
            mens2.setNomeDestinatario(usu1.getNome());
        }
        
        List<Message> mens = gerenciadorMessage.listar();
        
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
        
        request.setAttribute("Mensagem2", mensagem2);
        request.setAttribute("Mensagem3", mensagem3);
        request.setAttribute("emailEmissor", emailE);
        request.setAttribute("emailDestinatario", emailD);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("TelaMessagem.jsp");
        dispatcher.forward(request, response);
        
    }
    
}
