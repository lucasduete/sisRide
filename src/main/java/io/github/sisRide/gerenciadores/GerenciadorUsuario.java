package io.github.sisRide.gerenciadores;

import io.github.sisRide.factory.DaoFactory;
import io.github.sisRide.interfaces.DaoFactoryInterface;
import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;
import io.github.sisRide.model.Usuario;
import java.sql.SQLException;
import java.util.List;

public class GerenciadorUsuario {
    
    private DaoFactoryInterface fabrica = null;
    private UsuarioDaoInterface usuarioDao = null;

    public GerenciadorUsuario() {
        fabrica = DaoFactory.criarFabricaNeo4j();
        try {
            //usuDao = fabrica.criaDaoUsuario();
            usuarioDao = fabrica.criaDaoUsuario();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
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
        UsuarioDaoInterface usuarioDao = null;
        try {
            usuarioDao = fabrica.criaDaoUsuario();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        return usuarioDao.getUsuarioByEmail(email);
    }

    public String getFotoPerfil(String emailUser) {
        return usuarioDao.getFotoPerfil(emailUser);
    }
}