/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorFollow;
import io.github.sisRide.gerenciadores.GerenciadorRequestFollow;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Follow;
import io.github.sisRide.model.socialRequest.RequestFollow;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caio
 */
public class ConfimarSeguirCommand implements Command{
    
    private GerenciadorFollow gerfol;
    private Follow follow;
    private GerenciadorRequestFollow gerfolr;
    
    public ConfimarSeguirCommand() {

        this.gerfol = new GerenciadorFollow();
        this.follow = new Follow();
        this.gerfolr = new GerenciadorRequestFollow();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        
        String emailU = req.getParameter("emailU");
        String emailS = req.getParameter("emailS");
        
        follow.setEmailUsuario(emailU);
        follow.setEmailSeguidor(emailS);
        
        RequestFollow followr = new RequestFollow();
        
        followr.setEmailSeguidor(emailS);
        followr.setEmailUsuario(emailU);
        
        gerfol.salvar(follow);
        gerfolr.deletar(followr);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("TelaPrincipal.jsp");
        
        dispatcher.forward(req, res);
        
    }
    
}
