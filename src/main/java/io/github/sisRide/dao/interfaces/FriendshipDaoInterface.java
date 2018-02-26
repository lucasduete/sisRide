/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Friendship;
import java.util.List;

/**
 *
 * @author caio
 */
public interface FriendshipDaoInterface {
    
    public boolean salvar(Friendship friendship);
    
    public List<Friendship> listar();
    
    public boolean deletar(Friendship friendship);
    
    public List<Friendship> getAmigosByUsuario(String emailUsuario);
    
}
