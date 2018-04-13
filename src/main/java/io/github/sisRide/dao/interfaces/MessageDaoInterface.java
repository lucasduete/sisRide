package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Message;
import java.util.List;

public interface MessageDaoInterface {
    
    public boolean salvar(Message message);
    public List<Message> listar();
    public boolean deletar(Message message);
    
}
