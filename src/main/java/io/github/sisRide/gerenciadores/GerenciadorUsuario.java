package io.github.sisRide.gerenciadores;

import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;

public class GerenciadorUsuario {

    private DaoFactoryInterface fabrica = null;
    private UsuarioDaoInterface usuDao = null;

    public GerenciadorUsuario(){
        fabrica = DaoFactory.createFactory();
        usuDao = fabrica.criaDaoUsuario();
    }

    public boolean login(String email, String senha){
        return usuDao.login(email,senha);
    }
}