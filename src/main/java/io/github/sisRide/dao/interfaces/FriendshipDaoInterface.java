package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Friendship;
import io.github.sisRide.model.Usuario;

import java.util.List;

public interface FriendshipDaoInterface {
    
    public boolean salvar(Friendship friendship);
    public List<Usuario> listar();
    public boolean deletar(Friendship friendship);
    public List<Usuario> getAmigosByUsuario(String emailUsuario);
    
}
