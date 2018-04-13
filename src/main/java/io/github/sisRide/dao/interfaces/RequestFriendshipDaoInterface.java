package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.socialRequest.RequestFriendship;
import java.util.List;

public interface RequestFriendshipDaoInterface {
    
    public boolean salvar(RequestFriendship request);
    public List<RequestFriendship> listar();
    public boolean deletar(RequestFriendship request);
    
}
