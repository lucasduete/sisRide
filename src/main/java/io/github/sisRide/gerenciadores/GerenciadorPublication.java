/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.gerenciadores;

import io.github.sisRide.dao.interfaces.PublicationDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.Publication;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class GerenciadorPublication {
    
    private DaoFactoryInterface fabrica = null;
    private PublicationDaoInterface publicationDao = null;

    public GerenciadorPublication() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            publicationDao = fabrica.criaDaoPublication();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(Publication publication){
        return publicationDao.salvar(publication);
    }
    
    public List<Publication> listar(){
        return publicationDao.listar();
    }
    
    public boolean atualizar(Publication publication){
        return publicationDao.atualizar(publication);
    }
    
    public boolean deletar(Publication publication){
        return publicationDao.deletar(publication);
    }
    
    public List<Publication> getPublicationsByUsuario(String emailUsuario){
        return publicationDao.getPublicationsByUsuario(emailUsuario);
    }
}
