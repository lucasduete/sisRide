/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.gerenciadores;


import io.github.sisRide.dao.interfaces.MessageDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.Message;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class GerenciadorMessage {
    
    private DaoFactoryInterface fabrica = null;
    private MessageDaoInterface messageDao = null;

    public GerenciadorMessage() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            messageDao = fabrica.criaDaoMessage();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(Message message){
        return messageDao.salvar(message);
    }
    
    public List<Message> listar(){
        return messageDao.listar();
    }
    
    public boolean deletar(Message message){
        return messageDao.deletar(message);
    }
    
}
