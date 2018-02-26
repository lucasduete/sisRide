package io.github.sisRide.dao.postgres;

import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Follow;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowDaoPostgres {

    private final Connection conn;

    public FollowDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    public boolean salvar(Follow follow) {
        String sql = "INSERT INTO Follow(EmailSeguidor, EmailSeguindo) VALUES (?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, follow.getEmailSeguidor());
            stmt.setString(2, follow.getEmailSeguindo());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public List<Follow> listar() {
        String sql = "SELECT * FROM Follow;";
        List<Follow> follows = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Follow follow = new Follow(
                        rs.getString("EmailSeguidor"),
                        rs.getString("EmailSeguindo")
                );

                follows.add(follow);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return follows;
    }
}
