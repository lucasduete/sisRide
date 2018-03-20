package io.github.sisRide.gerenciadores;

import io.github.sisRide.dao.interfaces.RatingDaoInterface;
import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.model.Follow;
import io.github.sisRide.model.Rating;
import io.github.sisRide.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class GerenciadorRating {

    private DaoFactoryInterface fabrica = null;
    private RatingDaoInterface ratingDao = null;

    public GerenciadorRating() {
        fabrica = DaoFactory.criarFabricaNeo4j();

        try {
            ratingDao = fabrica.criarDaoRating();

        } catch (SQLException | ClassNotFoundException ex) {

            ex.printStackTrace();
        }
    }
    
    public boolean salvar(Rating rating) {

        return ratingDao.salvar(rating);
    }
    
    public boolean deletar(Rating rating) {

        return ratingDao.deletar(rating);
    }

    public boolean atualizar(Rating rating) {

        return ratingDao.atualizar(rating);
    }
    
    public int getNotaByUsuario(String emailUsuario) {

        return ratingDao.getNotaByUsuario(emailUsuario);
    }
}
