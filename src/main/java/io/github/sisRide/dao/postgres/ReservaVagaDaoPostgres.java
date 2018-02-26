package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.ReservaVagaDaoInterface;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.vaga.ReservaVaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaVagaDaoPostgres implements ReservaVagaDaoInterface{

    private final Connection conn;

    public ReservaVagaDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(ReservaVaga reservaVaga) {
        String sql = "INSERT INTO ReservaVaga(EmailPassageiro, IdViagem) VALUES (?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, reservaVaga.getEmailPassageiro());
            stmt.setInt(2, reservaVaga.getIdViagem());

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
    public List<ReservaVaga> listar() {
        String sql = "SELECT * FROM ReservaVaga;";
        List<ReservaVaga> reservas = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ReservaVaga reserva = new ReservaVaga (
                        rs.getString("EmailPassageiro"),
                        rs.getInt("IdViagem")
                );

                reservas.add(reserva);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return reservas;
    }

    /* CONCIDERADO DESNECESSARIO
        E desnecessario pois uma soliciatacao possui apenas o email do passageiro
        e o id da viagem, se eles forem modificados o proprio banco deve atualizar essa
        tabela.
    public boolean atualizar() {}
    */

    @Override
    public boolean deletar(ReservaVaga reserva) {
        String sql = "DELETE FROM ReservaVaga WHERE EmailPassageiro ILIKE ? " +
                "AND IdViagem = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, reserva.getEmailPassageiro());
            stmt.setInt(2, reserva.getIdViagem());

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
