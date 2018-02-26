/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.vaga.ReservaVaga;
import java.util.List;

/**
 *
 * @author caio
 */
public interface ReservaVagaDaoInterface {
    
    public boolean salvar(ReservaVaga reservaVaga);
    
    public List<ReservaVaga> listar();
    
    public boolean deletar(ReservaVaga reserva);
    
}
