package io.github.sisRide.interfaces;

import java.sql.SQLException;
import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;

public interface DaoFactoryInterface {

    public UsuarioDaoInterface criaDaoUsuario() throws SQLException, ClassNotFoundException;
}