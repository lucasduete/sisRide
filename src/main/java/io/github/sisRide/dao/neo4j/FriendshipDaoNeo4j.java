package io.github.sisRide.dao.neo4j;

import io.github.sisRide.dao.interfaces.FriendshipDaoInterface;
import io.github.sisRide.enums.Nodes;
import io.github.sisRide.enums.Relacionamentos;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Friendship;
import io.github.sisRide.model.Usuario;
import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.List;

public class FriendshipDaoNeo4j implements FriendshipDaoInterface {

    private final Driver conn;

    public FriendshipDaoNeo4j() {

        conn = Conexao.getConnectionNeo4j();
    }

    @Override
    public boolean salvar(Friendship friendship) {
        String sql = String.format("MATCH (u:%s{Email: $EmailUsuario}), (u2:%s{Email: $EmailAmigo}) " +
                "CREATE (u)-[:%s]->(u2)", Nodes.USUARIO, Nodes.USUARIO, Relacionamentos.FRIENDSHIP);

        try(Session session = conn.session()) {

            StatementResult result = session.run(sql,
                    Values.parameters("EmailUsuario", friendship.getEmailUsuario(),
                            "EmailAmigo", friendship.getEmailAmigo()));

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
                Nodes.USUARIO, Relacionamentos.FRIENDSHIP, Nodes.USUARIO);
        List<Usuario> amigos = new ArrayList<>();

        try(Session session = conn.session()) {

            StatementResult result = session.run(sql);

            while (result.hasNext()) {
                Record record = result.next();

                Usuario user = new Usuario();

                user.setEmail(record.get("Email").asString());
                user.setNome(record.get("Nome").asString());

                amigos.add(user);
            }

        } finally {
            conn.close();
        }
        return amigos;
    }

    @Override
    public boolean deletar(Friendship friendship) {
        String sql = String.format("MATCH (:%s{Email: $EmailUser})-[relation:%s]->(:%s) " +
                "DELETE relation", Nodes.USUARIO, Relacionamentos.FRIENDSHIP,
                Nodes.USUARIO);

        try(Session session = conn.session()) {
            StatementResult result = session.run(sql,
                    Values.parameters("EmailUser", friendship.getEmailUsuario()));

            if (!result.hasNext())
                return false;

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public List<Usuario> getAmigosByUsuario(String emailUsuario) {
        String sql = String.format("MATCH (:%s{Email: $EmailUsuario})-[:%s]->(entity:%s) " +
                "RETURN entity.Nome AS Nome, entity.Email AS Email",
                Nodes.USUARIO, Relacionamentos.FRIENDSHIP, Nodes.USUARIO);
        List<Usuario> amigos = new ArrayList<>();

        try(Session session = conn.session()) {

            StatementResult result = session.run(sql,
                    Values.parameters("EmailUsuario", emailUsuario));

            while (result.hasNext()) {
                Record record = result.next();

                Usuario user = new Usuario();

                user.setEmail(record.get("Email").asString());
                user.setNome(record.get("Nome").asString());

                amigos.add(user);
            }

        } finally {
            conn.close();
        }
        return amigos;
    }
}
