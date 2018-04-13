package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.RequestFriendshipDaoInterface;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.socialRequest.RequestFriendship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestFriendshipDaoPostgres implements RequestFriendshipDaoInterface{

    private final Connection conn;

    public RequestFriendshipDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(RequestFriendship request) {
        String sql = "INSERT INTO RequestFriendship(EmailUsuario, EmailAmigo) VALUES (?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, request.getEmailUsuario());
            stmt.setString(2, request.getEmailAmigo());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<RequestFriendship> listar() {
        String sql = "SELECT * FROM RequestFriendship;";
        List<RequestFriendship> requests = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RequestFriendship request = new RequestFriendship(
                        rs.getString("EmailUsuario"),
                        rs.getString("EmailAmigo")
                );

                requests.add(request);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return requests;
    }

    /* CONCIDERADO DESNECESSARIO
        E desnecessario pois uma soliciatacao possui apenas o email do seguidor
        e o email do usuario seguido, se eles forem modificados o proprio banco deve atualizar essa
        tabela.
    public boolean atualizar() {}
    */

    @Override
    public boolean deletar(RequestFriendship request) {
        String sql = "DELETE FROM RequestFriendship WHERE EmailUsuario ILIKE ? AND EmailUsuario ILIKE ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, request.getEmailUsuario());
            stmt.setString(2, request.getEmailAmigo());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
}
