package io.github.sisRide.dao.neo4j;

import io.github.sisRide.dao.interfaces.RatingDaoInterface;
import io.github.sisRide.enums.Nodes;
import io.github.sisRide.enums.Relacionamentos;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Rating;
import org.neo4j.driver.v1.*;

public class RatingDaoNeo4j implements RatingDaoInterface {

    private final Driver conn;

    public RatingDaoNeo4j() {

        conn = Conexao.getConnectionNeo4j();
    }

    @Override
    public boolean salvar(Rating rating) {
        String sql = String.format("MATCH (entity1:%s{Email: $EmailUsuario}), " +
                "(entity2:%s{Email: $EmailAvaliado}) " +
                "CREATE (entity1)-[relation:%s{Nota: $NotaRating}]->(entity2) " +
                "RETURN relation");

        try(Session session = conn.session()) {

            StatementResult result = session.run(sql,
                    Values.parameters("EmailUsuario", rating.getEmailUsuario(),
                            "NotaRating", rating.getNota(),
                            "EmailAvaliado", rating.getEmailAvaliado()));

            if (!result.hasNext())
                return false;

        } finally {
            conn.close();
        }
        return true;
    }

    @Override
    public boolean deletar(Rating rating) {
        String sql = String
                .format("MATCH (:%s{Email: $EmailUsuario})-[relation:%s]->(:%s{Email: $EmailAvaliado}) " +
                                "DELETE relation",
                        Nodes.USUARIO, Relacionamentos.RATING, Nodes.USUARIO);

        try(Session session = conn.session()) {

            session.run(sql, Values.parameters("EmailUsuario", rating.getEmailUsuario(),
                    "EmailAvaliado", rating.getEmailAvaliado()));

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public boolean atualizar(Rating rating) {
        String sql = String
                .format("MATCH (:%s{Email: $EmailUsuario})-[relation:%s]->(:%s{Email: $EmailAvaliado}) " +
                                "SET relation.Nota = $NotaRating",
                        Nodes.USUARIO, Relacionamentos.RATING, Nodes.USUARIO);

        try(Session session = conn.session()) {

            session.run(sql, Values.parameters("EmailUsuario", rating.getEmailUsuario(),
                    "EmailAvaliado", rating.getEmailAvaliado(),
                    "NotaRating", rating.getNota()));

        } finally {
            conn.close();
        }

        return true;
    }

    @Override
    public int getNotaByUsuario(String emailUsuario) {
        int nota = -1;
        String sql = String
                .format("MATCH (:%s{Email: $EmailUsuario})<-[relation:%s]-(:%s) " +
                            "RETURN avg(relation.Nota) AS Nota", Nodes.USUARIO,
                            Relacionamentos.RATING, Nodes.USUARIO);

        try(Session session = conn.session()) {

            StatementResult stmt = session.run(sql,
                    Values.parameters("EmailUsuario", emailUsuario));

            if (stmt.hasNext())
                nota = stmt.single().get("Nota").asInt();

        } finally {
            conn.close();
        }

        return nota;
    }
}
