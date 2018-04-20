package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorSolicitacaoVaga;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.vaga.SolicitacaoVaga;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RejeitaSolicitacaoVagaCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        GerenciadorSolicitacaoVaga solicitacaoVaga = new GerenciadorSolicitacaoVaga();

        int idViagem = Integer.parseInt(request.getParameter("idViagem"));
        String emailPassageiro = request.getParameter("emailPassageiro");

        SolicitacaoVaga solicitacao = new SolicitacaoVaga();
        solicitacao.setIdViagem(idViagem);
        solicitacao.setEmailPassageiro(emailPassageiro);

        if (solicitacaoVaga.deletar(solicitacao)) {
            response.setStatus(200);
            response.sendRedirect("CaronasOfertadas.jsp?code=1");
        } else {
            response.setStatus(400);
            response.sendRedirect("CaronasOfertadas.jsp?code=2");
        }

    }
}
