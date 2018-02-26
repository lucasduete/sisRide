/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.gerenciadores;


import io.github.sisRide.dao.interfaces.FollowDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.Follow;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class GerenciadorFollow {
    
    private DaoFactoryInterface fabrica = null;
    private FollowDaoInterface followDao = null;

    public GerenciadorFollow() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            followDao = fabrica.criaDaoFollow();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(Follow follow){
        return followDao.salvar(follow);
    }
    
    public List<Follow> listar(){
        return followDao.listar();
    }
    
    public boolean deletar(Follow follow){
        return followDao.deletar(follow);
    }
    
    public List<Follow> getFollowersByUsuario(String emailUsuario){
        return followDao.getFollowersByUsuario(emailUsuario);
    }
}
