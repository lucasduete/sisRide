package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorCarro;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Carro;
import io.github.sisRide.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastraVeiculoCommand implements Command {

    public CadastraVeiculoCommand() {

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        GerenciadorCarro gerenciadorCarro = new GerenciadorCarro();

        Carro carro = new Carro();
        Usuario user = (Usuario) request.getSession().getAttribute("Usuario");

        carro.setEmailProprieatario(user.getEmail());
        carro.setPlaca(request.getParameter("placa"));
        carro.setModelo(request.getParameter("modelo"));
        carro.setAno(Integer.parseInt(request.getParameter("ano")));

        String arCondicionado = request.getParameter("arCondicionado");
        if (arCondicionado.equals("sim"))
            carro.setArCondicionado(true);
        else if (arCondicionado.equals("não"))
            carro.setArCondicionado(false);

        if (gerenciadorCarro.salvar(carro)) {
            response.setStatus(200);
            response.sendRedirect("CadastraVeiculo.jsp?code=1");
        } else {
            response.setStatus(400);
            response.sendRedirect("CadastraVeiculo.jsp?code=2");
        }
    }
}
