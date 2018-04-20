package io.github.sisRide.gerenciadores;

import io.github.sisRide.dao.interfaces.RequestFollowDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.socialRequest.RequestFollow;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorRequestFollow {
    
    private DaoFactoryInterface fabrica = null;
    private RequestFollowDaoInterface requestfollowDao = null;

    public GerenciadorRequestFollow() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            requestfollowDao = fabrica.criaDaoRequestFollow();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(RequestFollow requestFollow){
        return requestfollowDao.salvar(requestFollow);
    }
    
    public List<RequestFollow> listar(){
        return requestfollowDao.listar();
    }
    
    public boolean deletar(RequestFollow request){
        return requestfollowDao.deletar(request);
    }
    
}
