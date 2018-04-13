package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.MessageDaoInterface;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoPostgres implements MessageDaoInterface{

    private final Connection conn;

    public MessageDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(Message message) {
        String sql = "INSERT INTO Message(EmailEmissor, EmailDestinatario, Mensagem) VALUES (?,?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, message.getEmailEmissor());
            stmt.setString(2, message.getEmailDestinatario());
            stmt.setString(3, message.getMensagem());

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
    public List<Message> listar() {
        String sql = "SELECT * FROM Message;";
        List<Message> messages = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Message message = new Message(
                        rs.getInt("Id"),
                        rs.getString("EmailEmissor"),
                        rs.getString("EmailDestinatario"),
                        rs.getString("Mensagem")
                );

                messages.add(message);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return messages;
    }

    /* CONCIDERADO DESNECESSARIO
        E desnecessario pois uma soliciatacao possui apenas o email do seguidor
        e o email do usuario seguido, se eles forem modificados o proprio banco deve atualizar essa
        tabela.
    public boolean atualizar() {}
    */

    @Override
    public boolean deletar(Message message) {
        String sql = "DELETE FROM Message WHERE Id = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, message.getId());

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
