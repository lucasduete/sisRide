package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorSolicitacaoVaga;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;
import io.github.sisRide.model.vaga.SolicitacaoVaga;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SolicitarVagaCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        GerenciadorSolicitacaoVaga solicitacaoVaga = new GerenciadorSolicitacaoVaga();

        Usuario user = (Usuario) request.getSession().getAttribute("Usuario");
        int idViagem = Integer.parseInt(request.getParameter("viagem"));

        SolicitacaoVaga solicitacao = new SolicitacaoVaga();

        solicitacao.setIdViagem(idViagem);
        solicitacao.setEmailPassageiro(user.getEmail());

        if (solicitacaoVaga.salvar(solicitacao))
            response.sendRedirect("BuscarCarona.jsp?code=1");
        else
            response.sendRedirect("BuscarCarona.jsp?code=2");

    }
}
