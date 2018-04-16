/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorRequestFriendship;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.socialRequest.RequestFriendship;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caio
 */
public class SolicitarAmizadeCommand implements Command{
    
    private GerenciadorRequestFriendship gerfri;
    private RequestFriendship friend;
    
    public SolicitarAmizadeCommand() {

        this.gerfri = new GerenciadorRequestFriendship();
        this.friend = new RequestFriendship();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        RequestFriendship reque = new RequestFriendship();
        
        String emailU = req.getParameter("emailU");
        String emailS = req.getParameter("emailS");
        
        

    }
    
}
