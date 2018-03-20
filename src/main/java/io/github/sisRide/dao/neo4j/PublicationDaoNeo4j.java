package io.github.sisRide.dao.neo4j;

import io.github.sisRide.dao.interfaces.PublicationDaoInterface;
import io.github.sisRide.enums.Nodes;
import io.github.sisRide.enums.Relacionamentos;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Publication;
import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.List;

public class PublicationDaoNeo4j implements PublicationDaoInterface {

    private final Driver conn;

    public PublicationDaoNeo4j() {

        conn = Conexao.getConnectionNeo4j();
    }

    @Override
    public boolean salvar(Publication publication) {
        String sql = null;
        StatementResult result = null;

        try(Session session = conn.session()) {

            sql = String.format("CREATE (entity:%s{IdLocal: $IdLocalidade, " +
                    "Mensagem: $MensagemUsuario}) RETURN ID(entity) AS id", Nodes.PUBLICATION);

            result = session.run(sql, Values.parameters("IdLocalidade",
                    publication.getIdLocal(), "MensagemUsuario",
                    publication.getMensagem()));

            if (!result.hasNext())
                return false;

            int idPublication = result.next().get("id").asInt();

            sql = String.format("MATCH (user:%s{Email : $EmailUser}), " +
                   "(pub:%s{ID: $idPublication}) CREATE (user)-[relation:%s]->(pub) " +
                   "RETURN relation", Nodes.USUARIO, Nodes.PUBLICATION,
                    Relacionamentos.PUBLISH);

            result = session.run(sql, Values.parameters("EmailUser",
                    publication.getEmailUsuario(), "idPublication", idPublication));

            if (!result.hasNext())
                return false;

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public List<Publication> listar() {
        String sql = String.format("MATCH (user:%s)-[:%s]->(pub:%s) " +
                        "RETURN ID(pub) AS id, pub.IdLocal AS IdLocal, pub.Mensagem " +
                        "AS Mensagem, user.Email AS EmailUser", Nodes.USUARIO,
                Relacionamentos.PUBLISH, Nodes.PUBLICATION);

        List<Publication> publications = new ArrayList<>();

        try(Session session = conn.session()) {

            StatementResult result = session.run(sql);

            while (result.hasNext()) {
                Record record = result.next();

                Publication publication = new Publication();

                publication.setEmailUsuario(record.get("EmailUser").asString());
                publication.setId(record.get("id").asInt());
                publication.setIdLocal(record.get("IdLocal").asInt());
                publication.setMensagem(record.get("Messagem").asString());

                publications.add(publication);
            }

        } finally {
            conn.close();
        }

        return publications;
    }

    @Override
    public boolean atualizar(Publication publication) {
        String sql = String.format("MATCH (entity:%s{ID: $IdPublication} SET " +
                "IdLocal = $IdLocalidade, Mensagem = $MensagemUsuario}) RETURN " +
                "ID(entity) AS id", Nodes.PUBLICATION);

        try(Session session = conn.session()) {

            StatementResult result = session.run(sql,
                    Values.parameters("IdPublication", publication.getId(),
                        "IdLocalidade", publication.getIdLocal(), "MensagemUsuario",
                        publication.getMensagem()));

            if (!result.hasNext())
                return false;

            int idPublication = result.next().get("id").asInt();
            publication.setId(idPublication);

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Publication publication) {
        String sql = String.format("MATCH (entity:%s{ID: $IdPublication} " +
                "DELETE entity", Nodes.PUBLICATION);

        try(Session session = conn.session()) {

            StatementResult result = session.run(sql);

            if (!result.hasNext())
                return false;

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public List<Publication> getPublicationsByUsuario(String emailUsuario) {
        String sql = String.format("MATCH (:%s{Email: $EmailUser})-[:%s]->(pub:%s) " +
                        "RETURN ID(pub) AS id, pub.IdLocal AS IdLocal, pub.Mensagem AS Mensagem",
                Nodes.USUARIO, Relacionamentos.PUBLISH, Nodes.PUBLICATION);
        List<Publication> publications = new ArrayList<>();

        try(Session session = conn.session()) {

            StatementResult result = session.run(sql,
                    Values.parameters("EmailUser", emailUsuario));

            while (result.hasNext()) {
                Record record = result.next();

                Publication publication = new Publication();

                publication.setEmailUsuario(emailUsuario);
                publication.setId(record.get("id").asInt());
                publication.setIdLocal(record.get("IdLocal").asInt());
                publication.setMensagem(record.get("Messagem").asString());

                publications.add(publication);
            }

        } finally {
            conn.close();
        }

        return publications;
    }
}
