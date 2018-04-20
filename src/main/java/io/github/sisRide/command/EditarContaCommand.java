package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarContaCommand implements Command {
    
    private GerenciadorUsuario gerenciadorUsuario;
    
    public EditarContaCommand() {

        this.gerenciadorUsuario = new GerenciadorUsuario();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        String email = req.getParameter("email");
        
        Usuario usuario = gerenciadorUsuario.getUsuarioByEmail(email);
        
        req.setAttribute("UsuarioC", usuario);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("TelaConfiguracao.jsp");
        dispatcher.forward(req, res);
    }
    
}
