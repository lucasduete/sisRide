package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.vaga.SolicitacaoVaga;
import java.util.List;

public interface SolicitacaoVagaDaoInterface {
    
    public boolean salvar(SolicitacaoVaga solicitacaoVaga);
    public List<SolicitacaoVaga> listar();
    public boolean deletar(SolicitacaoVaga solicitacao);
    
}
