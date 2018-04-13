package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.socialRequest.RequestFollow;
import java.util.List;

public interface RequestFollowDaoInterface {
    
    public boolean salvar(RequestFollow requestFollow);
    public List<RequestFollow> listar();
    public boolean deletar(RequestFollow request);
}
