package io.github.sisRide.factory;

import io.github.sisRide.dao.interfaces.*;
import io.github.sisRide.dao.neo4j.*;
import io.github.sisRide.interfaces.DaoFactoryInterface;

import java.sql.SQLException;

public class DaoFactoryNeo4j implements DaoFactoryInterface {

    @Override
    public UsuarioDaoInterface criaDaoUsuario() throws SQLException, ClassNotFoundException {

        return new UsuarioDaoNeo4j();
    }

    @Override
    public CarroDaoInterface criaDaoCarro() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public FollowDaoInterface criaDaoFollow() throws SQLException, ClassNotFoundException {
        return new FollowDaoNeo4j();
    }

    @Override
    public FriendshipDaoInterface criaDaoFriendship() throws SQLException, ClassNotFoundException {
        return new FriendshipDaoNeo4j();
    }

    @Override
    public LugarDaoInterface criaDaoLugar() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public MessageDaoInterface criaDaoMessage() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public PublicationDaoInterface criaDaoPublication() throws SQLException, ClassNotFoundException {
        return new PublicationDaoNeo4j();
    }

    @Override
    public RequestFollowDaoInterface criaDaoRequestFollow() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public RequestFriendshipDaoInterface criaDaoRequestFriendship() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ReservaVagaDaoInterface criaDaoReservaVaga() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public SolicitacaoVagaDaoInterface criaDaoSolicitacaoVaga() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ViagemDaoInterface criaDaoViagem() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public RatingDaoInterface criarDaoRating() throws SQLException, ClassNotFoundException {
        return new RatingDaoNeo4j();
    }
}
