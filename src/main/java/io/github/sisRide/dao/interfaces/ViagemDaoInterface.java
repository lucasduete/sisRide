/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Viagem;
import java.util.List;

/**
 *
 * @author caio
 */
public interface ViagemDaoInterface {
    
    public boolean salvar(Viagem viagem);
    
    public List<Viagem> listar();
    
    public boolean atualizar(Viagem viagem);
    
    public boolean deletar(Viagem viagem);
    
    public List<Viagem> getViagemByMotorista(String emailMotorista);
    
}
