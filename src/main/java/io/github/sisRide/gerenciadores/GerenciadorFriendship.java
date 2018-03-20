package io.github.sisRide.gerenciadores;

import io.github.sisRide.dao.interfaces.FriendshipDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.Friendship;
import io.github.sisRide.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class GerenciadorFriendship {
    
    private DaoFactoryInterface fabrica = null;
    private FriendshipDaoInterface friendshipDao = null;

    public GerenciadorFriendship() {
        fabrica = DaoFactory.criarFabricaNeo4j();

        try {
            friendshipDao = fabrica.criaDaoFriendship();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean salvar(Friendship friendship){
        return friendshipDao.salvar(friendship);
    }
    
    public List<Usuario> listar(){
        return friendshipDao.listar();
    }
    
    public boolean deletar(Friendship friendship){
        return friendshipDao.deletar(friendship);
    }
    
    public List<Usuario> getAmigosByUsuario(String emailUsuario){
        return friendshipDao.getAmigosByUsuario(emailUsuario);
    }
    
}
