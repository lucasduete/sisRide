/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.gerenciadores;

import io.github.sisRide.dao.interfaces.ViagemDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.Viagem;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class GerenciadorViagem {
    
    private DaoFactoryInterface fabrica = null;
    private ViagemDaoInterface viagemDao = null;

    public GerenciadorViagem() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            viagemDao = fabrica.criaDaoViagem();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(Viagem viagem){
        return viagemDao.salvar(viagem);
    }
    
    public List<Viagem> listar(){
        return viagemDao.listar();
    }
    
    public boolean atualizar(Viagem viagem){
        return viagemDao.atualizar(viagem);
    }
    
    public boolean deletar(Viagem viagem){
        return viagemDao.deletar(viagem);
    }
    
    public List<Viagem> getViagemByMotorista(String emailMotorista){
        return viagemDao.getViagemByMotorista(emailMotorista);
    }
    
}
