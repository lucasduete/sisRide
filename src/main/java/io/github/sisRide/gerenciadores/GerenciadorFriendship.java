/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.gerenciadores;


import io.github.sisRide.dao.interfaces.FriendshipDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.Friendship;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class GerenciadorFriendship {
    
    private DaoFactoryInterface fabrica = null;
    private FriendshipDaoInterface friendshipDao = null;

    public GerenciadorFriendship() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            friendshipDao = fabrica.criaDaoFriendship();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(Friendship friendship){
        return friendshipDao.salvar(friendship);
    }
    
    public List<Friendship> listar(){
        return friendshipDao.listar();
    }
    
    public boolean deletar(Friendship friendship){
        return friendshipDao.deletar(friendship);
    }
    
    public List<Friendship> getAmigosByUsuario(String emailUsuario){
        return friendshipDao.getAmigosByUsuario(emailUsuario);
    }
    
}
