package io.github.sisRide.dao.postgres;

import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Friendship;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class FriendshipDaoPostgres {

    private final Connection conn;

    public FriendshipDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    public boolean salvar(Friendship friendship) {
        String sql = "INSERT INTO Friendship(EmailUsuario, EmailAmigo) VALUES (?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, friendship.getEmailUsuario());
            stmt.setString(2, friendship.getEmailAmigo());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public List<Friendship> listar() {
        String sql = "SELECT * FROM Friendship;";
        List<Friendship> friendships = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Friendship friendship = new Friendship(
                        rs.getString("EmailUsuario"),
                        rs.getString("EmailAmigo")
                );

                friendships.add(friendship);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return friendships;
    }

    /* CONCIDERADO DESNECESSARIO
        E desnecessario pois uma soliciatacao possui apenas o email do seguidor
        e o email do usuario seguido, se eles forem modificados o proprio banco deve atualizar essa
        tabela.
    public boolean atualizar() {}
    */

    public boolean deletar(Friendship friendship) {
        String sql = "DELETE FROM Friendship WHERE EmailUsuario ILIKE ? AND EmailAmigo ILIKE ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, friendship.getEmailUsuario());
            stmt.setString(2, friendship.getEmailAmigo());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public List<Friendship> getAmigosByUsuario(String emailUsuario) {
        String sql = "SELECT EmailAmigo FROM Friendship WHERE EmailUsuario ILIKE ?;";
        List<Friendship> friends = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, emailUsuario);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Friendship friend = new Friendship(
                        emailUsuario,
                        rs.getString("EmailAmigo")
                );

                friends.add(friend);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return friends;
    }
}
