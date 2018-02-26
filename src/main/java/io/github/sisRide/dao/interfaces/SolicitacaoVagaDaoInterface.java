/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.vaga.SolicitacaoVaga;
import java.util.List;

/**
 *
 * @author caio
 */
public interface SolicitacaoVagaDaoInterface {
    
    public boolean salvar(SolicitacaoVaga solicitacaoVaga);
    
    public List<SolicitacaoVaga> listar();
    
    public boolean deletar(SolicitacaoVaga solicitacao);
    
}
