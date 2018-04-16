package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Lugar;
import java.util.List;

public interface LugarDaoInterface {
    
    public boolean salvar(Lugar lugar);
    public List<Lugar> listar();
    public boolean atualizar(Lugar lugar);
    public boolean deletar(Lugar lugar);
    public List<Lugar> getLugaresByUsuario(String emailUsuario);
    public int getPlaceIDByNome(String nome);
    public String getNomeByPlaceId(int placeId);
}
