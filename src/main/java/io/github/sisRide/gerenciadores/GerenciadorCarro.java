package io.github.sisRide.gerenciadores;

import io.github.sisRide.dao.interfaces.CarroDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.Carro;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorCarro {
    
    private DaoFactoryInterface fabrica = null;
    private CarroDaoInterface carroDao = null;

    public GerenciadorCarro() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            carroDao = fabrica.criaDaoCarro();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(Carro carro){
        return carroDao.salvar(carro);
    }
    
    public List<Carro> listar(){
        return carroDao.listar();
    }
    
    public boolean atualizar(Carro carro){
        return carroDao.atualizar(carro);
    }
    
    public boolean deletar(Carro carro){
        return carroDao.deletar(carro);
    }
    
    public Carro getCarroByPlaca(String placa){
        return carroDao.getCarroByPlaca(placa);
    }
    
    public List<Carro> getCarrosByMotorista(String emailMotorista){
        return carroDao.getCarrosByMotorista(emailMotorista);
    }
}
