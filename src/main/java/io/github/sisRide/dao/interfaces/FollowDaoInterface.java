/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Follow;
import io.github.sisRide.model.Usuario;

import java.util.List;

public interface FollowDaoInterface {
    
    public boolean salvar(Follow follow);
    public List<Follow> listar();
    public boolean deletar(Follow follow);
    public List<Usuario> getFollowersByUsuario(String emailUsuario);
}
