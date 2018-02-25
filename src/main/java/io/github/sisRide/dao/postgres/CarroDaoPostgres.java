package io.github.sisRide.dao.postgres;

import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Carro;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarroDaoPostgres {

    private final Connection conn;

    public CarroDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    public boolean salvar(Carro carro) {
        String sql = "INSERT INTO Carro(Placa, Modelo, ArCondicionado, Ano, EmailMotorista) " +
                "VALUES (?,?,?,?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getModelo());
            stmt.setBoolean(3, carro.getArCondicionado());
            stmt.setDate(4, Date.valueOf(carro.getAno()));
            stmt.setString(5, carro.getEmailAdministrador());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public List<Carro> listar() {

        String sql = "SELECT * FROM Carro;";
        List<Carro> carros = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Date data = rs.getDate("Ano");
                Instant instant = Instant.ofEpochMilli(data.getTime());

                Carro carro = new Carro(
                        rs.getString("Placa"),
                        rs.getString("Modelo"),
                        rs.getBoolean("ArCondicionado"),
                        LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate(),
                        rs.getString("EmailMotorista")
                );

                carros.add(carro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return carros;
    }



}
