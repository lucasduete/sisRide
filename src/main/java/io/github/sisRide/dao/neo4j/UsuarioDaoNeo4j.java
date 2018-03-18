package io.github.sisRide.dao.neo4j;

import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;
import io.github.sisRide.enums.Nodes;
import io.github.sisRide.exceptions.CredenciaisInvalidasException;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Usuario;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoNeo4j implements UsuarioDaoInterface {

    private final GraphDatabaseService conn;

    public UsuarioDaoNeo4j() {
        conn = Conexao.getConnectionNeo4j();
    }

    @Override
    public boolean salvar(Usuario usuario) {

        try(Transaction tx = conn.beginTx()) {

            Node node = conn.createNode(Nodes.USUARIO);

            node.setProperty("Email", usuario.getEmail());
            node.setProperty("Nome", usuario.getNome());
            node.setProperty("Senha", usuario.getSenha());
            node.setProperty("Nota", usuario.getNota());
            node.setProperty("FotoPerfil", usuario.getFotoPerfil());
            node.setProperty("Sexo", usuario.getSexo());
            node.setProperty("dataNasc", usuario.getDataNasc());
            node.setProperty("Profissao", usuario.getProfissao());
            node.setProperty("Cidade", usuario.getCidade());
            node.setProperty("Tipo", usuario.getTipo());

            tx.success();
        } finally {
            conn.shutdown();
        }

        return true;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try(Transaction tx = conn.beginTx()) {

            ResourceIterator<Node> iterator = conn.findNodes(Nodes.USUARIO);

            while (iterator.hasNext()) {
                Node node = iterator.next();

                Usuario user = new Usuario();
                user.setEmail((String) node.getProperty("Email"));
                user.setNome((String) node.getProperty("Nome"));
                user.setSenha((String) node.getProperty("Senha"));
                user.setNota((int) node.getProperty("Nota"));
                user.setFotoPerfil((String) node.getProperty("FotoPerfil"));
                user.setSexo((String) node.getProperty("Sexo"));
                user.setDataNasc((LocalDate) node.getProperty("DataNasc"));
                user.setProfissao((String) node.getProperty("Profissao"));
                user.setCidade((String) node.getProperty("Cidade"));
                user.setTipo((String) node.getProperty("Tipo"));

                usuarios.add(user);
            }

            tx.success();
        } finally {
            conn.shutdown();
        }

        return usuarios;
    }

    @Override
    public boolean atualizar(Usuario usuario) {

        try(Transaction tx = conn.beginTx()) {

            Node node = conn.findNode(Nodes.USUARIO, "Email", usuario.getEmail());

            node.setProperty("Nome", usuario.getNome());
            node.setProperty("Senha", usuario.getSenha());
            node.setProperty("Nota", usuario.getNota());
            node.setProperty("FotoPerfil", usuario.getFotoPerfil());
            node.setProperty("Sexo", usuario.getSexo());
            node.setProperty("dataNasc", usuario.getDataNasc());
            node.setProperty("Profissao", usuario.getProfissao());
            node.setProperty("Cidade", usuario.getCidade());
            node.setProperty("Tipo", usuario.getTipo());

            tx.success();
        } finally {
            conn.shutdown();
        }

        return true;
    }

    @Override
    public boolean deletar(Usuario usuario) {

        try(Transaction tx = conn.beginTx()) {

            Node node = conn.findNode(Nodes.USUARIO, "Email", usuario.getEmail());
            node.delete();

            tx.success();
        } finally {
            conn.shutdown();
        }

        return true;
    }

    @Override
    public boolean login(String email, String senha) {

        String sql = "SELECT Senha FROM Usuario WHERE Email ILIKE ?";

        try(Transaction tx = conn.beginTx()) {
            Node node = conn.findNode(Nodes.USUARIO, "Email", email);

            tx.success();

            if (node == null)
                throw new CredenciaisInvalidasException("Email Nao Encontrado.");

            if (!(senha.equals(node.getProperty("Senha"))))
                throw new CredenciaisInvalidasException("Senha Incorreta.");

        } catch (CredenciaisInvalidasException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conn.shutdown();
        }

        return true;
    }

    @Override
    public Usuario getUsuarioByEmail(String email) {
        Usuario user = null;

        try(Transaction tx = conn.beginTx()) {

            Node node = conn.findNode(Nodes.USUARIO, "Email", email);

            if (node != null) {
                user = new Usuario();

                user.setEmail((String) node.getProperty("Email"));
                user.setNome((String) node.getProperty("Nome"));
                user.setSenha((String) node.getProperty("Senha"));
                user.setNota((int) node.getProperty("Nota"));
                user.setFotoPerfil((String) node.getProperty("FotoPerfil"));
                user.setSexo((String) node.getProperty("Sexo"));
                user.setDataNasc((LocalDate) node.getProperty("DataNasc"));
                user.setProfissao((String) node.getProperty("Profissao"));
                user.setCidade((String) node.getProperty("Cidade"));
                user.setTipo((String) node.getProperty("Tipo"));
            }

            tx.success();
        } finally {
            conn.shutdown();
        }

        return user;
    }
}
