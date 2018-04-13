package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.LugarDaoInterface;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Lugar;

import javax.naming.ldap.PagedResultsControl;
import java.awt.*;
import java.awt.geom.RectangularShape;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LugarDaoPostgres implements LugarDaoInterface{

    private final Connection conn;

    public LugarDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(Lugar lugar) {
        String sql = "INSERT INTO Lugar(Descricao, Nome, Lat, Lng, EmailUsuario) VALUES (?,?,?,?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, lugar.getDescricao());
            stmt.setString(2, lugar.getNome());
            stmt.setFloat(3, lugar.getLat());
            stmt.setFloat(4, lugar.getLng());
            stmt.setString(5, lugar.getEmailUsuario());

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
    public List<Lugar> listar() {
        String sql = "SELECT * FROM Lugar;";
        List<Lugar> lugares = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Lugar lugar = new Lugar(
                        rs.getInt("Place_Id"),
                        rs.getString("Descricao"),
                        rs.getString("Nome"),
                        rs.getFloat("Lat"),
                        rs.getFloat("Lng"),
                        rs.getString("EmailUsuario")
                );

                lugares.add(lugar);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lugares;
    }

    @Override
    public boolean atualizar(Lugar lugar) {
        String sql = "UPDATE Lugar SET Descricao = ?, Nome = ?, Lat = ?, Lng = ?, EmailUsuario = ? " +
                "WHERE Place_Id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, lugar.getDescricao());
            stmt.setString(2, lugar.getNome());
            stmt.setFloat(3, lugar.getLat());
            stmt.setFloat(3, lugar.getLng());
            stmt.setString(4, lugar.getEmailUsuario());

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
    public boolean deletar(Lugar lugar) {
        String sql = "DELETE FROM Lugar WHERE Place_ID = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, lugar.getPlace_id());

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
    public List<Lugar> getLugaresByUsuario(String emailUsuario) {
        String sql = "SELECT Place_Id, Descricao, Nome, Lat, Lgn FROM Lugar WHERE EmailUsuario ILIKE ?;";
        List<Lugar> lugares = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, emailUsuario);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Lugar lugar = new Lugar(
                        rs.getInt("Place_Id"),
                        rs.getString("Descricao"),
                        rs.getString("Nome"),
                        rs.getFloat("Lat"),
                        rs.getFloat("Lng"),
                        emailUsuario
                );

                lugares.add(lugar);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lugares;
    }

}
