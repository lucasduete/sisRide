package io.github.sisRide.dao.postgres;

import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Publication;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublicationDaoPostgres {

    private final Connection conn;

    public PublicationDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    public boolean salvar(Publication publication) {
        String sql = "INSERT INTO Publication(EmailUsuario, IdLocal, Mensagem) VALUES(?,?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, publication.getEmailUsuario());
            stmt.setInt(2, publication.getIdLocal());
            stmt.setString(3, publication.getMensagem());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public List<Publication> listar() {
        String sql = "SELECT * FROM Publication;";
        List<Publication> publications = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Publication publication = new Publication(
                        rs.getInt("Id"),
                        rs.getString("EmailUsuario"),
                        rs.getInt("IdLocal"),
                        rs.getString("Mensagem")
                );

                publications.add(publication);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return publications;
    }
}
