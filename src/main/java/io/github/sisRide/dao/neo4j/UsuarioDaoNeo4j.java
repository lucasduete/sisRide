package io.github.sisRide.dao.neo4j;

import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;
import io.github.sisRide.enums.Nodes;
import io.github.sisRide.exceptions.CredenciaisInvalidasException;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Usuario;
import org.neo4j.driver.v1.*;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoNeo4j implements UsuarioDaoInterface {

    private final Driver conn;

    public UsuarioDaoNeo4j() {
        conn = Conexao.getConnectionNeo4j();
    }

    @Override
    public boolean salvar(Usuario usuario) {

        try(Session session = conn.session()) {

             StatementResult stmt = session.run("CREATE (u:$Usuario{Email: $Email, Nome: $Nome, " +
                    "Senha: $Senha, Nota: $Nota, FotoPerfil: $FotoPerfil, Sexo: $Sexo, " +
                    "DataNasc: $DataNasc, Profissao: $Profissao, Cidade: $Cidade, " +
                    "Tipo: $Tipo} RETURN u.Email)", Values.parameters(Nodes.USUARIO,
                    usuario.getEmail(), usuario.getNome(), usuario.getSenha(), usuario.getNota(),
                    usuario.getFotoPerfil(), usuario.getSexo(), usuario.getDataNasc(),
                    usuario.getProfissao(), usuario.getCidade(), usuario.getTipo()));

            if (stmt.hasNext())
                return false;

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try(Session session = conn.session()) {

            StatementResult stmt = session.run("MATCH (entity:$Entity) RETURN entity",
                    Values.parameters(Nodes.USUARIO));

            while (stmt.hasNext()) {
                Record record = stmt.next();

                Usuario user = new Usuario();
                user.setEmail(record.get("Email").asString());
                user.setNome(record.get("Nome").asString());
                user.setSenha(record.get("Senha").asString());
                user.setNota(record.get("Nota").asFloat());
                user.setFotoPerfil(record.get("FotoPerfil").asString());
                user.setSexo(record.get("Sexo").asString());
                user.setDataNasc((LocalDate) record.get("DataNasc").asObject());
                user.setProfissao(record.get("Profissao").asString());
                user.setCidade(record.get("Cidade").asString());
                user.setTipo(record.get("Tipo").asString());

                usuarios.add(user);
            }

        } finally {
            conn.close();
        }

        return usuarios;
    }

    @Override
    public boolean atualizar(Usuario usuario) {

        try(Session session = conn.session()) {

            StatementResult stmt = session.run("MATCH (u:$Usuario{Email: $Email}) u.Nome = $Nome, " +
                    "u.Senha = $Senha, u.Nota = $Nota, u.FotoPerfil = $FotoPerfil, u.Sexo = $Sexo, " +
                    "u.DataNasc = $DataNasc, u.Profissao = $Profissao, u.Cidade = $Cidade, " +
                    "u.Tipo = $Tipo RETURN u.Email)", Values.parameters(Nodes.USUARIO,
                    usuario.getEmail(), usuario.getNome(), usuario.getSenha(), usuario.getNota(),
                    usuario.getFotoPerfil(), usuario.getSexo(), usuario.getDataNasc(),
                    usuario.getProfissao(), usuario.getCidade(), usuario.getTipo()));

            if (stmt.hasNext())
                return false;

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Usuario usuario) {

        try(Session session = conn.session()) {
            StatementResult stmt = session.run("MATCH (entity:$Entity{Email: $Value}) DELETE entity",
                    Values.parameters(Nodes.USUARIO, usuario.getEmail()));
        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public boolean login(String email, String senha) {

        try(Session session = conn.session()) {
            StatementResult stmt = session.run("MATCH (entity:$Entity{Email: $Value}) " +
                    "RETURN entity.Email, entity.Senha", Values.parameters(Nodes.USUARIO,
                    email));

            if (!stmt.hasNext())
                throw new CredenciaisInvalidasException("Email Nao Encontrado.");

            Record record = stmt.next();

            if (!(senha.equals(record.get("Senha").asString())))
                throw new CredenciaisInvalidasException("Senha Incorreta.");

        } catch (CredenciaisInvalidasException ex) {
            ex.printStackTrace();
            return false;

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public Usuario getUsuarioByEmail(String email) {
        Usuario user = null;

        try(Session session = conn.session()) {
            StatementResult stmt = session.run("MATCH (entity:$Entity{Email: $Value}) " +
                            "RETURN entity", Values.parameters(Nodes.USUARIO, email));

            if (stmt.hasNext()) {
                Record record = stmt.next();

                user = new Usuario();
                user.setEmail(record.get("Email").asString());
                user.setNome(record.get("Nome").asString());
                user.setSenha(record.get("Senha").asString());
                user.setNota(record.get("Nota").asFloat());
                user.setFotoPerfil(record.get("FotoPerfil").asString());
                user.setSexo(record.get("Sexo").asString());
                user.setDataNasc((LocalDate) record.get("DataNasc").asObject());
                user.setProfissao(record.get("Profissao").asString());
                user.setCidade(record.get("Cidade").asString());
                user.setTipo(record.get("Tipo").asString());
            }

        } finally {
            conn.close();
        }

        return user;
    }
}
