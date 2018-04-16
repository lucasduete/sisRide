package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.ViagemDaoInterface;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Viagem;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ViagemDaoPostgres implements ViagemDaoInterface{

    private final Connection conn;

    public ViagemDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(Viagem viagem) {
        String sql = "INSERT INTO Viagem (DataViagem, Valor, Vagas, Horario, TransportarAnimal, NivelConversa, " +
                "PodeFumar, EmailMotorista, PlacaCarro, IdLocalSaida, IdLocalDestino) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setDate(1, Date.valueOf(viagem.getData()));
            stmt.setFloat(2, viagem.getValor());
            stmt.setInt(3, viagem.getVagas());
            stmt.setTime(4, Time.valueOf(viagem.getHorario()));
            stmt.setBoolean(5, viagem.getTransporteAnimal());
            stmt.setInt(6, viagem.getNivelConversa());
            stmt.setBoolean(7, viagem.getPodeFumar());
            stmt.setString(8, viagem.getEmailMotorista());
            stmt.setString(9, viagem.getPlacaCarro());
            stmt.setInt(10, viagem.getIdLocalSaida());
            stmt.setInt(11, viagem.getIdLocalDestino());

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
    public List<Viagem> listar() {
        String sql = "SELECT * FROM Viagem;";
        List<Viagem> viagens = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Date data = rs.getDate("DataViagem");
                Instant instant = Instant.ofEpochMilli(data.getTime());


                Viagem viagem = new Viagem(
                        rs.getInt("Id"),
                        LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate(),
                        rs.getFloat("Valor"),
                        rs.getInt("Vagas"),
                        rs.getTime("Horario").toLocalTime(),
                        rs.getBoolean("TransportarAnimal"),
                        rs.getInt("NivelConversa"),
                        rs.getBoolean("PodeFumar"),
                        rs.getString("EmailMotorista"),
                        rs.getString("PlacaCarro"),
                        rs.getInt("IdLocalSaida"),
                        rs.getInt("IdLocalDestino")
                );

                viagens.add(viagem);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return viagens;
    }

    @Override
    public boolean atualizar(Viagem viagem) {
        String sql = "UPDATE Viagem SET DataViagem = ?, Valor = ?, Vagas = ?, Horario = ?, TransportarAnimal = ?, " +
                "NivelConversa = ?, PodeFumar = ?, EmailMotorista = ?, PlacaCarro = ?, IdLocalSaida = ?, " +
                "IdLocalDestino = ? WHERE Id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setDate(1, Date.valueOf(viagem.getData()));
            stmt.setFloat(2, viagem.getValor());
            stmt.setInt(3, viagem.getVagas());
            stmt.setTime(4, Time.valueOf(viagem.getHorario()));
            stmt.setBoolean(5, viagem.getTransporteAnimal());
            stmt.setInt(6, viagem.getNivelConversa());
            stmt.setBoolean(7, viagem.getPodeFumar());
            stmt.setString(8, viagem.getEmailMotorista());
            stmt.setString(9, viagem.getPlacaCarro());
            stmt.setInt(10, viagem.getIdLocalSaida());
            stmt.setInt(11, viagem.getIdLocalDestino());
            stmt.setInt(12, viagem.getId());

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
    public boolean deletar(Viagem viagem) {
        String sql = "DELETE FROM SolicitacaoReserva WHERE IdViagem = ?;" +
                "DELETE FROM ReservaVaga WHERE IdViagem = ?;" +
                "DELETE FROM Viagem WHERE Id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, viagem.getId());
            stmt.setInt(2, viagem.getId());
            stmt.setInt(3, viagem.getId());

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
    public List<Viagem> getViagemByMotorista(String emailMotorista) {
        String sql = "SELECT Id, DataViagem, Valor, Vagas, Horario, TransportarAnimal, NivelConversa, PodeFumar, " +
                "PlacaCarro, IdLocalSaida, IdLocalDestino FROM Viagem WHERE EmailMotorista ILIKE ?;";
        List<Viagem> viagens = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, emailMotorista);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Date data = rs.getDate("DataViagem");
                Instant instant = Instant.ofEpochMilli(data.getTime());

                Viagem viagem = new Viagem (
                        rs.getInt("Id"),
                        LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate(),
                        rs.getFloat("Valor"),
                        rs.getInt("Vagas"),
                        rs.getTime("Horario").toLocalTime(),
                        rs.getBoolean("TransportarAnimal"),
                        rs.getInt("NivelConversa"),
                        rs.getBoolean("PodeFumar"),
                        emailMotorista,
                        rs.getString("PlacaCarro"),
                        rs.getInt("IdLocalSaida"),
                        rs.getInt("IdLocalDestino")
                );

                viagens.add(viagem);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return viagens;

    }

}
