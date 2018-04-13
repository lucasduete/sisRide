package io.github.sisRide.interfaces;

import io.github.sisRide.dao.interfaces.*;

import java.sql.SQLException;

public interface DaoFactoryInterface {

    public UsuarioDaoInterface criaDaoUsuario() throws SQLException, ClassNotFoundException;
    
    public CarroDaoInterface criaDaoCarro() throws SQLException, ClassNotFoundException;
    
    public FollowDaoInterface criaDaoFollow() throws SQLException, ClassNotFoundException;
    
    public FriendshipDaoInterface criaDaoFriendship() throws SQLException, ClassNotFoundException;
    
    public LugarDaoInterface criaDaoLugar() throws SQLException, ClassNotFoundException;
    
    public MessageDaoInterface criaDaoMessage() throws SQLException, ClassNotFoundException;
    
    public PublicationDaoInterface criaDaoPublication() throws SQLException, ClassNotFoundException;
    
    public RequestFollowDaoInterface criaDaoRequestFollow() throws SQLException, ClassNotFoundException;
    
    public RequestFriendshipDaoInterface criaDaoRequestFriendship() throws SQLException, ClassNotFoundException;
    
    public ReservaVagaDaoInterface criaDaoReservaVaga() throws SQLException, ClassNotFoundException;
    
    public SolicitacaoVagaDaoInterface criaDaoSolicitacaoVaga() throws SQLException, ClassNotFoundException;
    
    public ViagemDaoInterface criaDaoViagem() throws SQLException, ClassNotFoundException;

    public RatingDaoInterface criarDaoRating() throws SQLException, ClassNotFoundException;
    
}