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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caio
 */
public class BuscarUsuarioCommand implements Command{
    
    private GerenciadorUsuario gerusu;
    
    public BuscarUsuarioCommand(){
        
        this.gerusu = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        String search = req.getParameter("search");
        
        List<Usuario> usuarios = gerusu.listar();
        
        List<Usuario> collect = usuarios.stream() // Iterador sobre cada elemento da lista
                                        .filter((u) -> u.getNome().startsWith(search))  // Recupera para o stream de resultados quem atende a condição
                                        .collect(Collectors.toList());  // Collecta todos os elementos do stream para uma lista com os itens filtrados
        
        req.setAttribute("Usuarios", collect);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("BuscarUsuarios.jsp");
        
        dispatcher.forward(req, res);
        
    }
    
}
