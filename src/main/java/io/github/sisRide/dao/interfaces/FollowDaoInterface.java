package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Follow;
import io.github.sisRide.model.Usuario;

import java.util.List;

public interface FollowDaoInterface {
    
    public boolean salvar(Follow follow);
    public List<Usuario> listar();
    public boolean deletar(Follow follow);
    public List<Usuario> getFollowersByUsuario(String emailUsuario);
}
