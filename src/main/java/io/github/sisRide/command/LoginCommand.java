package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorRequestFollow;
import io.github.sisRide.gerenciadores.GerenciadorRequestFriendship;
import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Solicitacao;
import io.github.sisRide.model.Usuario;
import io.github.sisRide.model.socialRequest.RequestFollow;
import io.github.sisRide.model.socialRequest.RequestFriendship;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    
    private GerenciadorUsuario gerusu;
    private GerenciadorRequestFriendship reqfri;
    private GerenciadorRequestFollow reqfol;
    
    public LoginCommand(){
        this.gerusu = new GerenciadorUsuario();
        this.reqfri = new GerenciadorRequestFriendship();
        this.reqfol = new GerenciadorRequestFollow();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //UsuarioDaoInterface usuarioDao = DaoFactory.criarFabricaPostgres().criaDaoUsuario();
        
        Solicitacao solicitacaoA = new Solicitacao();
        Solicitacao solicitacaoS = new Solicitacao();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        

        if(gerusu.login(email,senha)) {
            response.setStatus(HttpServletResponse.SC_OK);
            Usuario usuario = gerusu.getUsuarioByEmail(email);
            request.getSession().setAttribute("Usuario", usuario);
            
            List<RequestFriendship> requestfriendship = reqfri.listar();
            
            for (RequestFriendship reque : requestfriendship){
                if(reque.getEmailUsuario().equals(email)){
                    Usuario usus = gerusu.getUsuarioByEmail(reque.getEmailAmigo());
                    solicitacaoA.setFotoPerfil(usus.getFotoPerfil());
                    solicitacaoA.setNome(usus.getNome());
                    solicitacaoA.setEmail(usus.getEmail());
                }
                
            }
            
            List<RequestFollow> requestfollow = reqfol.listar();
            
            for (RequestFollow reque : requestfollow){
                if(reque.getEmailUsuario().equals(email)){
                    Usuario usus = gerusu.getUsuarioByEmail(reque.getEmailSeguidor());
                    solicitacaoS.setFotoPerfil(usus.getFotoPerfil());
                    solicitacaoS.setNome(usus.getNome());
                    solicitacaoS.setEmail(usus.getEmail());
                }
                
            }

//            request.getSession().setAttribute("SolicitacaoS", solicitacaoS);
//            request.getSession().setAttribute("SolicitacaoA", solicitacaoA);

            response.sendRedirect("TelaPrincipal.jsp");
        
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendRedirect("TeladeLogin.jsp?error=1");
        }
    }
}