package io.github.sisRide.factory;

import io.github.sisRide.dao.interfaces.*;

import java.sql.SQLException;

import io.github.sisRide.dao.postgres.CarroDaoPostgres;
import io.github.sisRide.dao.postgres.FollowDaoPostgres;
import io.github.sisRide.dao.postgres.FriendshipDaoPostgres;
import io.github.sisRide.dao.postgres.LugarDaoPostgres;
import io.github.sisRide.dao.postgres.MessageDaoPostgres;
import io.github.sisRide.dao.postgres.PublicationDaoPostgres;
import io.github.sisRide.dao.postgres.RequestFollowDaoPostgres;
import io.github.sisRide.dao.postgres.RequestFriendshipDaoPostgres;
import io.github.sisRide.dao.postgres.ReservaVagaDaoPostgres;
import io.github.sisRide.dao.postgres.SolicitacaoVagaDaoPostgres;
import io.github.sisRide.dao.postgres.UsuarioDaoPostgres;
import io.github.sisRide.dao.postgres.ViagemDaoPostgres;
import io.github.sisRide.interfaces.DaoFactoryInterface;

public class DaoFactoryPostgres implements DaoFactoryInterface {

    @Override
    public UsuarioDaoInterface criaDaoUsuario() throws SQLException, ClassNotFoundException {
        return new UsuarioDaoPostgres();
    }

    @Override
    public CarroDaoInterface criaDaoCarro() throws SQLException, ClassNotFoundException {
        return new CarroDaoPostgres();
    }

    @Override
    public FollowDaoInterface criaDaoFollow() throws SQLException, ClassNotFoundException {
        return new FollowDaoPostgres();
    }

    @Override
    public FriendshipDaoInterface criaDaoFriendship() throws SQLException, ClassNotFoundException {
        return new FriendshipDaoPostgres();
    }

    @Override
    public LugarDaoInterface criaDaoLugar() throws SQLException, ClassNotFoundException {
        return new LugarDaoPostgres();
    }

    @Override
    public MessageDaoInterface criaDaoMessage() throws SQLException, ClassNotFoundException {
        return new MessageDaoPostgres();
    }

    @Override
    public PublicationDaoInterface criaDaoPublication() throws SQLException, ClassNotFoundException {
        return new PublicationDaoPostgres();
    }

    @Override
    public RequestFollowDaoInterface criaDaoRequestFollow() throws SQLException, ClassNotFoundException {
        return new RequestFollowDaoPostgres();
    }

    @Override
    public RequestFriendshipDaoInterface criaDaoRequestFriendship() throws SQLException, ClassNotFoundException {
        return new RequestFriendshipDaoPostgres();
    }

    @Override
    public ReservaVagaDaoInterface criaDaoReservaVaga() throws SQLException, ClassNotFoundException {
        return new ReservaVagaDaoPostgres();
    }

    @Override
    public SolicitacaoVagaDaoInterface criaDaoSolicitacaoVaga() throws SQLException, ClassNotFoundException {
        return new SolicitacaoVagaDaoPostgres();
    }

    @Override
    public ViagemDaoInterface criaDaoViagem() throws SQLException, ClassNotFoundException {
        return new ViagemDaoPostgres();
    }

    @Override
    public RatingDaoInterface criarDaoRating() throws SQLException, ClassNotFoundException {
        return null;
    }
}