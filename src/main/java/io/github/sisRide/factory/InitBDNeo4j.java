package io.github.sisRide.factory;

import io.github.sisRide.enums.Nodes;
import org.neo4j.driver.v1.*;

public class InitBDNeo4j {

    public static void start() {
        initalization();
    }

    private static void initalization() {
        Driver conn = Conexao.getConnectionNeo4j();

        try(Session session = conn.session()) {

            //Inicializa Propriedades do BD

            session.run("CREATE INDEX ON :$Entidade($Field)", Values.parameters(Nodes.USUARIO, "Email"));
            session.run("CREATE CONSTRAINT ON (entity:$Entidade) ASSERT entity.$Field IS UNIQUE"
                    , Values.parameters(Nodes.USUARIO, "Email"));

        } finally {
            conn.close();
        }
    }
}
