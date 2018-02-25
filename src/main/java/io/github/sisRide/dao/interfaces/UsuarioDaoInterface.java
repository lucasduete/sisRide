package io.github.sisRide.dao.interfaces;

import java.util.List;
import io.github.sisRide.model.Usuario;

public interface UsuarioDaoInterface {

    public boolean salvar(Usuario usuario);

    public List<Usuario> listar();

    public boolean atualizar(Usuario usuario);

    public boolean deletar(Usuario usuario);

    public boolean login(String email, String senha);

    public Usuario getUsuarioByEmail(String email);

}
