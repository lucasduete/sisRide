package io.github.sisRide.command;

import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    
    private GerenciadorUsuario gerusu;
    
    public LoginCommand(){
        this.gerusu = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        //UsuarioDaoInterface usuarioDao = DaoFactory.criarFabricaPostgres().criaDaoUsuario();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if(gerusu.login(email,senha)) {
            response.setStatus(HttpServletResponse.SC_OK);
            Usuario usuario = gerusu.getUsuarioByEmail(email);
            request.getSession().setAttribute("Usuario", usuario);
            response.sendRedirect("TelaPrincipal.jsp");
        
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendRedirect("TeladeLogin.jsp?error=1");
        }
    }
}