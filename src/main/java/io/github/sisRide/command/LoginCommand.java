package io.github.sisRide.command;

import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.Command;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        UsuarioDaoInterface usuarioDao = DaoFactory.criarFabricaPostgres().criaDaoUsuario();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if(usuarioDao.login(email,senha)) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("inicio.jsp");
        
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendRedirect("index.jsp?error=1");
        }
    }
}