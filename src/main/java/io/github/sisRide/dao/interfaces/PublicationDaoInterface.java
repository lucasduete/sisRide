package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Publication;
import java.util.List;

public interface PublicationDaoInterface {
    
    public boolean salvar(Publication publication);
    public List<Publication> listar();
    public boolean atualizar(Publication publication);
    public boolean deletar(Publication publication);
    public List<Publication> getPublicationsByUsuario(String emailUsuario);
    
}
