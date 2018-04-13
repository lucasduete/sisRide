/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Lugar;
import java.util.List;

/**
 *
 * @author caio
 */
public interface LugarDaoInterface {
    
    public boolean salvar(Lugar lugar);
    
    public List<Lugar> listar();
    
    public boolean atualizar(Lugar lugar);
    
    public boolean deletar(Lugar lugar);
    
    public List<Lugar> getLugaresByUsuario(String emailUsuario);
}
