package io.github.sisRide.factory;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:postgresql://localhost:5432/sisRide";
    private static final String usuario = "postgres";
    private static final String senha = "postgres";

    protected static final File BANCONEO4J = new File("sisRide.db");
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, usuario, senha);
    }

    public static GraphDatabaseService getConnectionNeo4j() {
        GraphDatabaseService graphDB = new GraphDatabaseFactory().newEmbeddedDatabase(BANCONEO4J);
        return graphDB;
    }

}
