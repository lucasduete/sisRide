package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExcluirContaCommand implements Command {
    
    private GerenciadorUsuario gerenciadorUsuario;
    
    public ExcluirContaCommand() {

        this.gerenciadorUsuario = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        String email = request.getParameter("email");
        
        Usuario usuario = gerenciadorUsuario.getUsuarioByEmail(email);
        gerenciadorUsuario.deletar(usuario);
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        response.sendRedirect("TeladeLogin.jsp");
        
    }
    
}
