/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.gerenciadores;


import io.github.sisRide.dao.interfaces.SolicitacaoVagaDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.vaga.SolicitacaoVaga;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class GerenciadorSolicitacaoVaga {
    
    private DaoFactoryInterface fabrica = null;
    private SolicitacaoVagaDaoInterface solicitacaovagaDao = null;

    public GerenciadorSolicitacaoVaga() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            solicitacaovagaDao = fabrica.criaDaoSolicitacaoVaga();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(SolicitacaoVaga solicitacaoVaga){
        return solicitacaovagaDao.salvar(solicitacaoVaga);
    }
    
    public List<SolicitacaoVaga> listar(){
        return solicitacaovagaDao.listar();
    }
    
    public boolean deletar(SolicitacaoVaga solicitacao){
        return solicitacaovagaDao.deletar(solicitacao);
    }
    
}
