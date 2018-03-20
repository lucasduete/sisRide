package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Carro;
import java.util.List;

public interface CarroDaoInterface {
    
    public boolean salvar(Carro carro);
    public List<Carro> listar();
    public boolean atualizar(Carro carro);
    public boolean deletar(Carro carro);
    public Carro getCarroByPlaca(String placa);
    public List<Carro> getCarrosByMotorista(String emailMotorista);
}
