package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorLugar;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Lugar;
import io.github.sisRide.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastraLocalCommand implements Command {

    public void CadastraLocalCommand() {

    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        GerenciadorLugar gerenciadorLugar = new GerenciadorLugar();

        Lugar lugar = new Lugar();
        Usuario user = (Usuario) req.getSession().getAttribute("Usuario");

        lugar.setNome(req.getParameter("nome"));
        lugar.setDescricao(req.getParameter("descricao"));
        lugar.setLat(Double.parseDouble(req.getParameter("lat")));
        lugar.setLng(Double.parseDouble(req.getParameter("lng")));
        lugar.setEmailUsuario(user.getEmail());

        if (gerenciadorLugar.salvar(lugar)) {
            res.setStatus(200);
            res.sendRedirect("CadastraLocal.jsp?code=1");
        } else {
            res.setStatus(400);
            res.sendRedirect("CadastraLocal.jsp?code=2");
        }

    }
}
