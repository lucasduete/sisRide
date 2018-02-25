package io.github.sisRide.appcontroller;

import io.github.sisRide.interfaces.Command;
import io.github.sisRide.gerenciadores.GerenciadorUsuario;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Command{

    private GerenciadorUsuario ger;
    
    public LoginController(){
        this.ger = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) throws SQLException, ClassNotFoundException, IOException, ServletException {

        String email = requisicao.getParameter("email");
        String senha = requisicao.getParameter("senha");

        if(ger.login(email,senha)){
            
            resposta.sendRedirect("inicio.jsp");
        
        }else{
            resposta.sendRedirect("index.jsp?error=1");
        }
    }
}