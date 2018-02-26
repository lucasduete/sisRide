/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.socialRequest.RequestFollow;
import java.util.List;

/**
 *
 * @author caio
 */
public interface RequestFollowDaoInterface {
    
    public boolean salvar(RequestFollow requestFollow);
    
    public List<RequestFollow> listar();
    
    public boolean deletar(RequestFollow request);
}
