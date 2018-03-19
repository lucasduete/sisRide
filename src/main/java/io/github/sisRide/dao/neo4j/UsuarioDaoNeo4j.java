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
        String sql = String.format("CREATE (u:%s{Email: $Email, Nome: $Nome, " +
                "Senha: $Senha, Nota: $Nota, FotoPerfil: $FotoPerfil, Sexo: $Sexo, " +
                "DataNasc: $DataNasc, Profissao: $Profissao, Cidade: $Cidade, " +
                "Tipo: $Tipo}) RETURN u.Email", Nodes.USUARIO);

        try(Session session = conn.session()) {
             StatementResult stmt = session.run(sql, Values.parameters("Email", usuario.getEmail(),
                     "Nome", usuario.getNome(), "Senha", usuario.getSenha(), "Nota", usuario.getNota(),
                     "FotoPerfil", usuario.getFotoPerfil(), "Sexo", usuario.getSexo(), "DataNasc",
                     usuario.getDataNasc().toString(), "Profissao", usuario.getProfissao(),
                     "Cidade", usuario.getCidade(), "Tipo", usuario.getTipo()));

            if (!stmt.hasNext())
                return false;

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = String.format("MATCH (entity:%s) RETURN entity", Nodes.USUARIO);

        try(Session session = conn.session()) {

            StatementResult stmt = session.run(sql);

            while (stmt.hasNext()) {
                Record record = stmt.next();

                Usuario user = new Usuario();
                user.setEmail(record.get("Email").asString());
                user.setNome(record.get("Nome").asString());
                user.setSenha(record.get("Senha").asString());
                user.setNota(record.get("Nota").asFloat());
                user.setFotoPerfil(record.get("FotoPerfil").asString());
                user.setSexo(record.get("Sexo").asString());
                user.setDataNasc(LocalDate.parse(record.get("DataNasc").asString()));
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
        String sql = String.format("MATCH (u:%s{Email: $Email}) u.Nome = $Nome, " +
                "u.Senha = $Senha, u.Nota = $Nota, u.FotoPerfil = $FotoPerfil, u.Sexo = $Sexo, " +
                "u.DataNasc = $DataNasc, u.Profissao = $Profissao, u.Cidade = $Cidade, " +
                "u.Tipo = $Tipo RETURN u.Email)", Nodes.USUARIO);

        try(Session session = conn.session()) {

            StatementResult stmt = session.run(sql, Values.parameters("Email", usuario.getEmail(),
                    "Nome", usuario.getNome(), "Senha", usuario.getSenha(), "Nota", usuario.getNota(),
                    "FotoPerfil", usuario.getFotoPerfil(), "Sexo", usuario.getSexo(), "DataNasc",
                    usuario.getDataNasc().toString(), "Profissao", usuario.getProfissao(),
                    "Cidade", usuario.getCidade(), "Tipo", usuario.getTipo()));

            if (stmt.hasNext())
                return false;

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Usuario usuario) {
        String sql = String.format("MATCH (entity:%s{Email: $Value}) DELETE entity", Nodes.USUARIO);

        try(Session session = conn.session()) {
            StatementResult stmt = session.run(sql,
                    Values.parameters("Value", usuario.getEmail()));
        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public boolean login(String email, String senha) {
        String sql = String.format("MATCH (entity:%s{Email: $Value}) " +
                "RETURN entity.Email, entity.Senha", Nodes.USUARIO);

        try(Session session = conn.session()) {
            StatementResult stmt = session.run(sql, Values.parameters("Value", email));

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
        String sql = String.format("MATCH (entity:%s{Email: $Value}) " +
                "RETURN entity", Nodes.USUARIO);

        try(Session session = conn.session()) {
            StatementResult stmt = session.run(sql,
                    Values.parameters("Value", email));

            if (stmt.hasNext()) {
                Record record = stmt.next();

                user = new Usuario();
                user.setEmail(record.get("Email").asString());
                user.setNome(record.get("Nome").asString());
                user.setSenha(record.get("Senha").asString());
                user.setNota(record.get("Nota").asFloat());
                user.setFotoPerfil(record.get("FotoPerfil").asString());
                user.setSexo(record.get("Sexo").asString());
                user.setDataNasc(LocalDate.parse(record.get("DataNasc").asString()));
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
