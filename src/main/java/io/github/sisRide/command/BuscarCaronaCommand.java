package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorViagem;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Viagem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;
import java.io.IOException;
import java.util.List;

public class BuscarCaronaCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        GerenciadorViagem gerenciadorViagem = new GerenciadorViagem();

        String localSaida = request.getParameter("localSaida");
        String localChegada = request.getParameter("localChegada");
        List<Viagem> viagens = gerenciadorViagem.searchViagem(localSaida, localChegada);

        request.setAttribute(
                "viagens", viagens
        );

        RequestDispatcher dispatcher = request.getRequestDispatcher("BuscarCarona.jsp");
        dispatcher.forward(request, response);

    }
}
