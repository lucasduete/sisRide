/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.gerenciadores;


import io.github.sisRide.dao.interfaces.RequestFriendshipDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.socialRequest.RequestFriendship;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class GerenciadorRequestFriendship {
    
    private DaoFactoryInterface fabrica = null;
    private RequestFriendshipDaoInterface requestfriendshipDao = null;

    public GerenciadorRequestFriendship() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            requestfriendshipDao = fabrica.criaDaoRequestFriendship();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(RequestFriendship request){
        return requestfriendshipDao.salvar(request);
    }
    
    public List<RequestFriendship> listar(){
        return requestfriendshipDao.listar();
    }
    
    public boolean deletar(RequestFriendship request){
        return requestfriendshipDao.deletar(request);
    }
    
}
