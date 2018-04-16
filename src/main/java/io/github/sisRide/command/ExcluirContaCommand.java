/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author caio
 */
public class ExcluirContaCommand implements Command{
    
    private GerenciadorUsuario gerusu;
    
    public ExcluirContaCommand() {

        this.gerusu = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        String email = req.getParameter("email");
        
        Usuario usuario = gerusu.getUsuarioByEmail(email);
        
        gerusu.deletar(usuario);
        
        HttpSession session = req.getSession();
        
        session.invalidate();
        
        res.sendRedirect("TeladeLogin.jsp");
        
    }
    
}
