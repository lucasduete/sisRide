package io.github.sisRide.gerenciadores;

import io.github.sisRide.dao.interfaces.ReservaVagaDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.vaga.ReservaVaga;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorReservaVaga {
    
    private DaoFactoryInterface fabrica = null;
    private ReservaVagaDaoInterface reservavagaDao = null;

    public GerenciadorReservaVaga() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            reservavagaDao = fabrica.criaDaoReservaVaga();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(ReservaVaga reservaVaga){
        return reservavagaDao.salvar(reservaVaga);
    }
    
    public List<ReservaVaga> listar(){
        return reservavagaDao.listar();
    }
    
    public boolean deletar(ReservaVaga reserva){
        return reservavagaDao.deletar(reserva);
    }

    public List<ReservaVaga> listarById(int idViagem) {
        return reservavagaDao.listarById(idViagem);
    }
}
