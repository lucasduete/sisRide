package io.github.sisRide.interfaces;

import io.github.sisRide.dao.interfaces.CarroDaoInterface;
import io.github.sisRide.dao.interfaces.FollowDaoInterface;
import io.github.sisRide.dao.interfaces.FriendshipDaoInterface;
import io.github.sisRide.dao.interfaces.LugarDaoInterface;
import io.github.sisRide.dao.interfaces.MessageDaoInterface;
import io.github.sisRide.dao.interfaces.PublicationDaoInterface;
import io.github.sisRide.dao.interfaces.RequestFollowDaoInterface;
import io.github.sisRide.dao.interfaces.RequestFriendshipDaoInterface;
import io.github.sisRide.dao.interfaces.ReservaVagaDaoInterface;
import io.github.sisRide.dao.interfaces.SolicitacaoVagaDaoInterface;
import java.sql.SQLException;
import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;
import io.github.sisRide.dao.interfaces.ViagemDaoInterface;

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
    
}