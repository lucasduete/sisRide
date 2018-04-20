package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarUsuarioCommand implements Command {
    
    private GerenciadorUsuario gerenciadorUsuario;
    
    public BuscarUsuarioCommand(){
        
        this.gerenciadorUsuario = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        String search = request.getParameter("search");
        System.out.println(search);
        
        List<Usuario> usuarios = gerenciadorUsuario.listar();
        
//        List<Usuario> collect = usuarios.stream() // Iterador sobre cada elemento da lista
//                                        .filter((u) -> u.getNome().startsWith(search))  // Recupera para o stream de resultados quem atende a condição
//                                        .collect(Collectors.toList());  // Collecta todos os elementos do stream para uma lista com os itens filtrados
//
        List<Usuario> users = new ArrayList<>();

        usuarios.forEach((usuario) -> {
            if (usuario.getNome().contains(search))
                users.add(usuario);
        });

        request.setAttribute("Usuarios", users);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("BuscarUsuarios.jsp");
        dispatcher.forward(request, response);
        
    }
    
}
