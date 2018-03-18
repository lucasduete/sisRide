package io.github.sisRide.factory;

import io.github.sisRide.enums.Nodes;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Transaction;

import java.io.File;

public class InitBDNeo4j {

    public static void start() {
        File banco = Conexao.BANCONEO4J;

        if (!banco.exists())
            initalization();
    }

    private static void initalization() {
        GraphDatabaseService conn = Conexao.getConnectionNeo4j();

        try(Transaction tx = conn.beginTx()) {

            //Inicializa Propriedades do BD
            conn.schema().indexFor(Nodes.USUARIO).on("Email").create();
            conn.schema().constraintFor(Nodes.USUARIO).assertPropertyIsUnique("email").create();

            tx.success();
        } finally {
            conn.shutdown();
        }
    }
}
