package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Viagem;
import java.util.List;

public interface ViagemDaoInterface {
    
    public boolean salvar(Viagem viagem);
    public List<Viagem> listar();
    public boolean atualizar(Viagem viagem);
    public boolean deletar(Viagem viagem);
    public List<Viagem> getViagemByMotorista(String emailMotorista);
    public List<Viagem> getViagensWithSaida(String localSaida);
    public List<Viagem> getViagensWithDestino(String localDestino);
    public List<Viagem> getViagensWithSaidaDestino(String localSaida, String localDestino);

    
}
