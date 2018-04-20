package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorFollow;
import io.github.sisRide.gerenciadores.GerenciadorRequestFollow;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Follow;
import io.github.sisRide.model.socialRequest.RequestFollow;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfimarSeguirCommand implements Command {
    
    private GerenciadorFollow gerenciadorFollow;
    private GerenciadorRequestFollow gerenciadorRequestFollow;
    private Follow follow;
    
    public ConfimarSeguirCommand() {

        this.gerenciadorFollow = new GerenciadorFollow();
        this.gerenciadorRequestFollow = new GerenciadorRequestFollow();
        this.follow = new Follow();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        
        String emailU = request.getParameter("emailU");
        String emailS = request.getParameter("emailS");
        
        follow.setEmailUsuario(emailU);
        follow.setEmailSeguidor(emailS);
        
        RequestFollow followr = new RequestFollow();
        
        followr.setEmailSeguidor(emailS);
        followr.setEmailUsuario(emailU);
        
        gerenciadorFollow.salvar(follow);
        gerenciadorRequestFollow.deletar(followr);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("TelaPrincipal.jsp");
        dispatcher.forward(request, response);
        
    }
    
}
