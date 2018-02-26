/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.socialRequest.RequestFriendship;
import java.util.List;

/**
 *
 * @author caio
 */
public interface RequestFriendshipDaoInterface {
    
    public boolean salvar(RequestFriendship request);
    
    public List<RequestFriendship> listar();
    
    public boolean deletar(RequestFriendship request);
    
}
