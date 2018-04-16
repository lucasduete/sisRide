/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorFriendship;
import io.github.sisRide.gerenciadores.GerenciadorRequestFriendship;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Friendship;
import io.github.sisRide.model.socialRequest.RequestFriendship;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caio
 */
public class ConfimarAmizadeCommand implements Command{
    
    private GerenciadorFriendship gerfri;
    private Friendship friend;
    private GerenciadorRequestFriendship gerfrir;
    private RequestFriendship friendr;
    
    public ConfimarAmizadeCommand() {

        this.gerfri = new GerenciadorFriendship();
        this.friend = new Friendship();
        this.gerfrir = new GerenciadorRequestFriendship();
        this.friendr = new RequestFriendship();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        String emailU = req.getParameter("emailU");
        String emailS = req.getParameter("emailS");
        
        friend.setEmailUsuario(emailU);
        friend.setEmailAmigo(emailS);
        
        friendr.setEmailAmigo(emailS);
        friendr.setEmailUsuario(emailU);
        
        gerfri.salvar(friend);
        gerfrir.deletar(friendr);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("TelaPrincipal.jsp");
        
        dispatcher.forward(req, res);
    }
    
}
