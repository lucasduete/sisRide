package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.RequestFollowDaoInterface;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.socialRequest.RequestFollow;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestFollowDaoPostgres implements RequestFollowDaoInterface{

    private final Connection conn;

    public RequestFollowDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(RequestFollow requestFollow) {
        String sql = "INSERT INTO RequestFollow(emailUsuario, emailSeguidor) VALUES (?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, requestFollow.getEmailUsuario());
            stmt.setString(2, requestFollow.getEmailSeguidor());

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
    public List<RequestFollow> listar() {
        String sql = "SELECT * FROM RequestFollow;";
        List<RequestFollow> requests = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RequestFollow request = new RequestFollow(
                        rs.getString("EmailUsuario"),
                        rs.getString("EmailSeguidor")
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
    public boolean deletar(RequestFollow request) {
        String sql = "DELETE FROM RequestFollow WHERE emailUsuario ILIKE ? AND emailSeguidor ILIKE ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, request.getEmailUsuario());
            stmt.setString(2, request.getEmailSeguidor());

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
