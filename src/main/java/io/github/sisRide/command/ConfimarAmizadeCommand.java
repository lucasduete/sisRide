package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorFriendship;
import io.github.sisRide.gerenciadores.GerenciadorRequestFriendship;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Friendship;
import io.github.sisRide.model.socialRequest.RequestFriendship;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfimarAmizadeCommand implements Command {
    
    private GerenciadorFriendship gerenciadorFriendship;
    private GerenciadorRequestFriendship gerenciadorRequestFriendship;

    private Friendship friendship;
    private RequestFriendship requestFriendship;
    
    public ConfimarAmizadeCommand() {

        this.gerenciadorFriendship = new GerenciadorFriendship();
        this.gerenciadorRequestFriendship = new GerenciadorRequestFriendship();

        this.friendship = new Friendship();
        this.requestFriendship = new RequestFriendship();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        String emailU = request.getParameter("emailU");
        String emailS = request.getParameter("emailS");
        
        friendship.setEmailUsuario(emailU);
        friendship.setEmailAmigo(emailS);
        
        requestFriendship.setEmailAmigo(emailS);
        requestFriendship.setEmailUsuario(emailU);
        
        gerenciadorFriendship.salvar(friendship);
        gerenciadorRequestFriendship.deletar(requestFriendship);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("TelaPrincipal.jsp");
        dispatcher.forward(request, response);
    }
    
}
