package io.github.sisRide.gerenciadores;

import io.github.sisRide.dao.interfaces.FollowDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.Follow;
import io.github.sisRide.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class GerenciadorFollow {
    
    private DaoFactoryInterface fabrica = null;
    private FollowDaoInterface followDao = null;

    public GerenciadorFollow() {
        fabrica = DaoFactory.criarFabricaNeo4j();

        try {
            followDao = fabrica.criaDaoFollow();

        } catch (SQLException | ClassNotFoundException ex) {

            ex.printStackTrace();
        }
    }
    
    public boolean salvar(Follow follow) {

        return followDao.salvar(follow);
    }
    
    public List<Usuario> listar() {

        return followDao.listar();
    }
    
    public boolean deletar(Follow follow) {

        return followDao.deletar(follow);
    }
    
    public List<Usuario> getFollowersByUsuario(String emailUsuario) {

        return followDao.getFollowersByUsuario(emailUsuario);
    }
}
