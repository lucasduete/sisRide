package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.CarroDaoInterface;
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

public class CarroDaoPostgres implements CarroDaoInterface{

    private final Connection conn;

    public CarroDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(Carro carro) {
        String sql = "INSERT INTO Carro(Placa, Modelo, ArCondicionado, Ano, EmailMotorista) " +
                "VALUES (?,?,?,?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getModelo());
            stmt.setBoolean(3, carro.getArCondicionado());
            stmt.setInt(4, carro.getAno());
            stmt.setString(5, carro.getEmailProprieatario());

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
                        rs.getInt("Ano"),
                        rs.getString("EmailMotorista")
                );

                carros.add(carro);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return carros;
    }

    @Override
    public boolean atualizar(Carro carro) {

        String sql = "UPDATE Carro SET Placa = ?, Modelo = ?, ArCondicionado = ?, Ano = ?, " +
                "EmailMotorista = ? WHERE Placa = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getModelo());
            stmt.setBoolean(3, carro.getArCondicionado());
            stmt.setInt(4, carro.getAno());
            stmt.setString(5, carro.getEmailProprieatario());
            stmt.setString(6, carro.getPlaca());

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
    public boolean deletar(Carro carro) {
        String sql = "DELETE FROM Carro WHERE Placa = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, carro.getPlaca());

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
    public Carro getCarroByPlaca(String placa) {

        String sql = "SELECT * FROM Carro WHERE Placa = ?;";
        Carro carro = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            carro = new Carro();

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Date data = rs.getDate("Ano");
                Instant instant = Instant.ofEpochMilli(data.getTime());

                carro.setPlaca(rs.getString("Placa"));
                carro.setModelo(rs.getString("Modelo"));
                carro.setArCondicionado(rs.getBoolean("ArCondicionado"));
                carro.setAno(rs.getInt("Ano"));
                carro.setEmailProprieatario(rs.getString("EmailMotorista"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return carro;
    }

    @Override
    public List<Carro> getCarrosByMotorista(String emailMotorista) {
        String sql = "SELECT Placa, Modelo, ArCondicionado, Ano FROM Carro " +
                "WHERE EmailMotorista = ?;";
        List<Carro> carros = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, emailMotorista);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Date data = rs.getDate("Ano");
                Instant instant = Instant.ofEpochMilli(data.getTime());

                Carro carro = new Carro(
                        rs.getString("Placa"),
                        rs.getString("Modelo"),
                        rs.getBoolean("ArCondicionado"),
                        rs.getInt("Ano"),
                        rs.getString(emailMotorista)
                );

                carros.add(carro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return carros;
    }

}
