package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorReservaVaga;
import io.github.sisRide.gerenciadores.GerenciadorSolicitacaoVaga;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.vaga.ReservaVaga;
import io.github.sisRide.model.vaga.SolicitacaoVaga;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AceitaSolicitacaoVagaCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        GerenciadorReservaVaga reservaVaga = new GerenciadorReservaVaga();

        int idViagem = Integer.parseInt(request.getParameter("idViagem"));
        String emailPassageiro = request.getParameter("emailPassageiro");

        ReservaVaga reserva = new ReservaVaga();
        reserva.setEmailPassageiro(emailPassageiro);
        reserva.setIdViagem(idViagem);

        SolicitacaoVaga solicitacaoVaga = new SolicitacaoVaga();
        solicitacaoVaga.setIdViagem(idViagem);
        solicitacaoVaga.setEmailPassageiro(emailPassageiro);

        new GerenciadorSolicitacaoVaga().deletar(solicitacaoVaga);

        if (reservaVaga.salvar(reserva)) {
            response.setStatus(200);
            response.sendRedirect("CaronasOfertadas.jsp?code=1");
        } else {
            response.setStatus(400);
            response.sendRedirect("CaronasOfertadas.jsp?code=2");
        }

    }
}
