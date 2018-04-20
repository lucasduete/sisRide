package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorRequestFollow;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.socialRequest.RequestFollow;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NaoConfimarSeguirCommand implements Command {
    
    private GerenciadorRequestFollow gerenciadorRequestFollow;
    
    public NaoConfimarSeguirCommand() {
        
        this.gerenciadorRequestFollow = new GerenciadorRequestFollow();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        String emailU = request.getParameter("emailU");
        String emailS = request.getParameter("emailS");
        
        RequestFollow requestFollow = new RequestFollow();
        
        requestFollow.setEmailSeguidor(emailS);
        requestFollow.setEmailUsuario(emailU);
        
        gerenciadorRequestFollow.deletar(requestFollow);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("TelaPrincipal.jsp");
        dispatcher.forward(request, response);
    }
    
}
