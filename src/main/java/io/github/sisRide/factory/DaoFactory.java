package io.github.sisRide.factory;

public class DaoFactory {

    public static DaoFactoryPostgres criarFabricaPostgres() {
        return new DaoFactoryPostgres();
    }
    
}

