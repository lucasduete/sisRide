package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.vaga.ReservaVaga;
import java.util.List;

public interface ReservaVagaDaoInterface {
    
    public boolean salvar(ReservaVaga reservaVaga);
    public List<ReservaVaga> listar();
    public boolean deletar(ReservaVaga reserva);
    public List<ReservaVaga> listarById(int idViagem);
    
}
