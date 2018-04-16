package io.github.sisRide.gerenciadores;

import io.github.sisRide.dao.interfaces.LugarDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.Lugar;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorLugar {
    
    private DaoFactoryInterface fabrica = null;
    private LugarDaoInterface lugarDao = null;

    public GerenciadorLugar() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            lugarDao = fabrica.criaDaoLugar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(Lugar lugar){
        return lugarDao.salvar(lugar);
    }
    
    public List<Lugar> listar(){
        return lugarDao.listar();
    }
    
    public boolean atualizar(Lugar lugar){
        return lugarDao.atualizar(lugar);
    }
    
    public boolean deletar(Lugar lugar){
        return lugarDao.deletar(lugar);
    }
    
    public List<Lugar> getLugaresByUsuario(String emailUsuario){
        return lugarDao.getLugaresByUsuario(emailUsuario);
    }

    public int getPlaceId(String nomeLugar) {
        return lugarDao.getPlaceIDByNome(nomeLugar);
    }

    public String getNome(int placeId) {
        return lugarDao.getNomeByPlaceId(placeId);
    }
}
