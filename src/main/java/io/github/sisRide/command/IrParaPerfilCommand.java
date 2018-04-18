package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IrParaPerfilCommand implements Command{
    
    private GerenciadorUsuario gerenciadorUsuario;
    
    public IrParaPerfilCommand() {

        this.gerenciadorUsuario = new GerenciadorUsuario();
    }
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        
        String email = request.getParameter("email");
        
        Usuario usuario = gerenciadorUsuario.getUsuarioByEmail(email);
        
        request.setAttribute("UsuarioP", usuario);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Perfil.jsp");
        dispatcher.forward(request, response);
    }
    
}
