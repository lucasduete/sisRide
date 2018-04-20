package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorRequestFollow;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.socialRequest.RequestFollow;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SolicitarSeguirCommand implements Command {
    
    private GerenciadorRequestFollow gerenciadorRequestFollow;
    
    public SolicitarSeguirCommand() {

        this.gerenciadorRequestFollow = new GerenciadorRequestFollow();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        RequestFollow requestFollow = new RequestFollow();
        
        String emailU = request.getParameter("emailU");
        String emailS = request.getParameter("emailS");
        
        requestFollow.setEmailUsuario(emailU);
        requestFollow.setEmailSeguidor(emailS);
        
        gerenciadorRequestFollow.salvar(requestFollow);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("TelaPrincipal.jsp");
        dispatcher.forward(request, response);
    }
    
}
