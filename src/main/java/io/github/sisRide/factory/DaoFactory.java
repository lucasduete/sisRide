package io.github.sisRide.factory;

import io.github.sisRide.interfaces.DaoFactoryInterface;

public class DaoFactory {

    public static DaoFactoryInterface criarFabricaPostgres() {
        return new DaoFactoryPostgres();
    }
    
}

