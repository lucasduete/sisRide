package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorLugar;
import io.github.sisRide.gerenciadores.GerenciadorViagem;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;
import io.github.sisRide.model.Viagem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CadastraViagemCommand implements Command {

    public CadastraViagemCommand() {

    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        GerenciadorViagem gerenciadorViagem = new GerenciadorViagem();

        Usuario user = (Usuario) req.getSession().getAttribute("Usuario");
        Viagem viagem = new Viagem();

        viagem.setEmailMotorista(user.getEmail());
        viagem.setNivelConversa(Integer.parseInt(req.getParameter("nivelConversa")));
        viagem.setVagas(Integer.parseInt(req.getParameter("QuantidadeVagas")));
        viagem.setValor(Float.parseFloat(req.getParameter("valor")));
        viagem.setPlacaCarro(req.getParameter("carro"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(
                req.getParameter("data"), formatter
        );
        viagem.setData(data);

        formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horario = LocalTime.parse(
                req.getParameter("hora"), formatter
        );
        viagem.setHorario(horario);



        String podeFumar = req.getParameter("podeFumar");
        if (podeFumar.equals("sim"))
            viagem.setPodeFumar(true);
        else if (podeFumar.equals("não"))
            viagem.setPodeFumar(false);

        String transporteAnimal = req.getParameter("transporteAnimal");
        if (transporteAnimal.equals("sim"))
            viagem.setTransporteAnimal(true);
        else if (transporteAnimal.equals("não"))
            viagem.setTransporteAnimal(false);

        viagem.setIdLocalSaida(
                new GerenciadorLugar().getPlaceId(
                        req.getParameter("lugarSaida")
                )
        );

        viagem.setIdLocalDestino(
                new GerenciadorLugar().getPlaceId(
                        req.getParameter("lugarChegada")
                )
        );

        if (gerenciadorViagem.salvar(viagem)) {
            res.setStatus(200);
            res.sendRedirect("CadastraViagem.jsp?code=1");
        } else {
            res.setStatus(400);
            res.sendRedirect("CadastraViagem.jsp?code=2");
        }
    }
}
