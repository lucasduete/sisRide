package io.github.sisRide.dao.interfaces;

import io.github.sisRide.model.Rating;

public interface RatingDaoInterface {

    public boolean salvar(Rating rating);
    public boolean deletar(Rating rating);
    public boolean atualizar(Rating rating);
    public int getNotaByUsuario(String emailUsuario);
}
