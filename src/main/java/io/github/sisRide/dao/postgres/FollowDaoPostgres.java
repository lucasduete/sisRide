package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.FollowDaoInterface;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Follow;
import io.github.sisRide.model.Usuario;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowDaoPostgres implements FollowDaoInterface{

    private final Connection conn;

    public FollowDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(Follow follow) {
        String sql = "INSERT INTO Follow(EmailUsuario, EmailSeguidor) VALUES (?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, follow.getEmailUsuario());
            stmt.setString(2, follow.getEmailSeguidor());

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
    public List<Usuario> listar() {
        String sql = "SELECT * FROM Follow;";
        List<Follow> follows = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Follow follow = new Follow(
                        rs.getString("EmailUsuario"),
                        rs.getString("EmailSeguidor")
                );

                follows.add(follow);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /* CONCIDERADO DESNECESSARIO
        E desnecessario pois uma soliciatacao possui apenas o email do seguidor
        e o email do usuario seguido, se eles forem modificados o proprio banco deve atualizar essa
        tabela.
    public boolean atualizar() {}
    */

    @Override
    public boolean deletar(Follow follow) {
        String sql = "DELETE FROM Follow WHERE EmailUsuario ILIKE ? AND EmailSeguidor ILIKE ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, follow.getEmailUsuario());
            stmt.setString(2, follow.getEmailSeguidor());

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
    public List<Usuario> getFollowersByUsuario(String emailUsuario) {
        String sql = "SELECT EmailSeguidor FROM Follow WHERE EmailUsuario ILIKE ?;";
        List<Follow> followers = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, emailUsuario);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Follow follower = new Follow(
                        emailUsuario,
                        rs.getString("EmailSeguidor")
                );

                followers.add(follower);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
