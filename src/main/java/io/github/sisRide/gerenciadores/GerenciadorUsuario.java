package io.github.sisRide.gerenciadores;

import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;
import io.github.sisRide.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorUsuario {
    
    private DaoFactoryInterface fabrica = null;
    private UsuarioDaoInterface usuarioDao = null;

    public GerenciadorUsuario() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            //usuDao = fabrica.criaDaoUsuario();
            usuarioDao = fabrica.criaDaoUsuario();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(String email, String senha){
        return usuarioDao.login(email,senha);
    }
    
    public boolean salvar(Usuario usuario) {
        return usuarioDao.salvar(usuario);
    }
    
    public List<Usuario> listar() {
        return usuarioDao.listar();
    }
    
    public boolean atualizar(Usuario usuario) {
        return usuarioDao.atualizar(usuario);
    }
    
    public boolean deletar(Usuario usuario) {
        return usuarioDao.deletar(usuario);
    }
    
    public Usuario getUsuarioByEmail(String email) {
        return usuarioDao.getUsuarioByEmail(email);
    }
}