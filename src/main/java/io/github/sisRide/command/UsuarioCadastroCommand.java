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


public class UsuarioCadastroCommand implements Command {

    private GerenciadorUsuario gerusu;
    
    public LoginCommand(){
        this.gerusu = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {

        Usuario usuario = new Usuario();

        String email = request.getParameter("email");

        if(gerusu.getUsuarioByEmail(email) == null) {
            String nome = requisicao.getParameter("nome");
            String senha = requisicao.getParameter("password");
            String sexo = requisicao.getParameter("group1");
            String tipo = requisicao.getParameter("group2");
            LocalDate dataNasc = LocalDate.parse(requisicao.getParameter("dataNasc"));
            String fotoPerfil = 

            if(gerusu.salvar(usuario)){
                resposta.sendRedirect("TeladeLogin.jsp");
            }else{
                resposta.sendRedirect("TeladeCadastroUsuario.jsp?error=1");
            }

        }else{
            resposta.sendRedirect("TeladeCadastroUsuario.jsp?error=2");
        }
    }

}