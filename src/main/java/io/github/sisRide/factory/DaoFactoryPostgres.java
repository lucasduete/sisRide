package io.github.sisRide.factory;

import java.sql.SQLException;
import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;
import io.github.sisRide.dao.postgres.UsuarioDaoPostgres;
import io.github.sisRide.interfaces.DaoFactoryInterface;

public class DaoFactoryPostgres implements DaoFactoryInterface {

    public static UsuarioDaoInterface criaDaoUsuario() throws SQLException, ClassNotFoundException{
        return new UsuarioDaoPostgres();
    }

}