package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.gerenciadores.GerenciadorViagem;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Viagem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoElasCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        GerenciadorViagem gerenciadorViagem = new GerenciadorViagem();
        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();

        String localSaida = request.getParameter("localSaida");
        String localChegada = request.getParameter("localChegada");
        List<Viagem> tempViagens = gerenciadorViagem.searchViagem(localSaida, localChegada);
        List<Viagem> viagens = new ArrayList<>();

        tempViagens.forEach((viagem) -> {
            if (gerenciadorUsuario.getUsuarioByEmail(viagem.getEmailMotorista()).getSexo().equals("feminino"))
                viagens.add(viagem);
        });

        request.setAttribute(
                "viagens", viagens
        );

        RequestDispatcher dispatcher = request.getRequestDispatcher("SoElas.jsp");
        dispatcher.forward(request, response);

    }
}
