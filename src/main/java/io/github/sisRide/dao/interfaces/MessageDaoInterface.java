/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Message;
import java.util.List;

/**
 *
 * @author caio
 */
public interface MessageDaoInterface {
    
    public boolean salvar(Message message);
    
    public List<Message> listar();
    
    public boolean deletar(Message message);
    
}
