/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Publication;
import java.util.List;

/**
 *
 * @author caio
 */
public interface PublicationDaoInterface {
    
    public boolean salvar(Publication publication);
    
    public List<Publication> listar();
    
    public boolean atualizar(Publication publication);
    
    public boolean deletar(Publication publication);
    
    public List<Publication> getPublicationsByUsuario(String emailUsuario);
    
}
