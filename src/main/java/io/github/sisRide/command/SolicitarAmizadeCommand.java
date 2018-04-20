package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorRequestFriendship;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.socialRequest.RequestFriendship;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SolicitarAmizadeCommand implements Command {
    
    private GerenciadorRequestFriendship gerenciadorRequestFriendship;
    private RequestFriendship requestFriendship;
    
    public SolicitarAmizadeCommand() {

        this.gerenciadorRequestFriendship = new GerenciadorRequestFriendship();
        this.requestFriendship = new RequestFriendship();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        String emailU = request.getParameter("emailU");
        String emailS = request.getParameter("emailS");
        
        requestFriendship.setEmailAmigo(emailS);
        requestFriendship.setEmailUsuario(emailU);
        
        gerenciadorRequestFriendship.salvar(requestFriendship);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("TelaPrincipal.jsp");
        dispatcher.forward(request, response);

    }
    
}
