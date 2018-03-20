package io.github.sisRide.dao.neo4j;

import io.github.sisRide.dao.interfaces.FollowDaoInterface;
import io.github.sisRide.enums.Nodes;
import io.github.sisRide.enums.Relacionamentos;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Follow;
import io.github.sisRide.model.Usuario;
import org.neo4j.driver.v1.*;

import javax.xml.soap.Node;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowDaoNeo4j implements FollowDaoInterface {

    private final Driver conn;

    public FollowDaoNeo4j() {
        conn = Conexao.getConnectionNeo4j();
    }

    @Override
    public boolean salvar(Follow follow) {

        String sql = String.format("MATCH (u:%s{Email: $EmailUsuario}), (u2:%s{Email: $EmailSeguidor}) " +
                "CREATE (u)-[:%s]->(u2)", Nodes.USUARIO, Nodes.USUARIO, Relacionamentos.FOLLOW);

        try (Session session = conn.session()) {
            StatementResult result = session.run(sql,
                    Values.parameters("EmailUsuario", follow.getEmailUsuario(),
                            "EmailSeguidor", follow.getEmailSeguidor()));

            if (!result.hasNext())
                return false;

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public List<Usuario> listar() {
        String sql = String.format("MATCH (:%s)-[:%s]->(entity:%s) " +
                        "RETURN entity.Nome AS Nome, entity.Email AS Email",
                Nodes.USUARIO, Relacionamentos.FOLLOW, Nodes.USUARIO);
        List<Usuario> follows = new ArrayList<>();

        try (Session session = conn.session()) {

            StatementResult result = session.run(sql);

            while (result.hasNext()) {
                Record record = result.next();

                Usuario user = new Usuario();

                user.setNome(record.get("Nome").asString());
                user.setEmail(record.get("Email").asString());

                follows.add(user);
            }

        } finally {
            conn.close();
        }

        return follows;
    }

    /* CONCIDERADO DESNECESSARIO
        E desnecessario pois uma soliciatacao possui apenas o email do seguidor
        e o email do usuario seguido, se eles forem modificados o proprio banco deve atualizar essa
        tabela.
    public boolean atualizar() {}
    */

    @Override
    public boolean deletar(Follow follow) {
        String sql = String.format("MATCH (:%s{Email: $EmailUser})-[relation:%s]->(:%s{Email: $EmailSeguidor}) " +
                "DELETE relation", Nodes.USUARIO, Relacionamentos.FOLLOW, Nodes.USUARIO);

        try(Session session = conn.session()) {
            StatementResult result = session.run(sql,
                    Values.parameters("EmailUser", follow.getEmailUsuario(),
                            "EmailSeguidor", follow.getEmailSeguidor()));

            if (!result.hasNext())
                return false;

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public List<Usuario> getFollowersByUsuario(String emailUsuario) {
        String sql = String.format("MATCH (:%s{Email: $EmailUser})-[:%s]->(entity:%s) " +
                        "RETURN entity.Nome AS Nome, entity.Email AS Email",
                Nodes.USUARIO, Relacionamentos.FOLLOW, Nodes.USUARIO);
        List<Usuario> follows = new ArrayList<>();

        try (Session session = conn.session()) {

            StatementResult result = session.run(sql,
                    Values.parameters("EmailUser", emailUsuario));

            while (result.hasNext()) {
                Record record = result.next();

                Usuario user = new Usuario();
                user.setNome(record.get("Nome").asString());
                user.setEmail(record.get("Email").asString());

                follows.add(user);
            }

        } finally {
            conn.close();
        }

        return follows;
    }

}
