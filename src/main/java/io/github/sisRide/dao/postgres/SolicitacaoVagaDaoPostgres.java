package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.SolicitacaoVagaDaoInterface;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.vaga.SolicitacaoVaga;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoVagaDaoPostgres implements SolicitacaoVagaDaoInterface{

    private final Connection conn;

    public SolicitacaoVagaDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(SolicitacaoVaga solicitacaoVaga) {
        String sql = "INSERT INTO SolicitacaoVaga (EmailPassageiro, IdViagem) VALUES (?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, solicitacaoVaga.getEmailPassageiro());
            stmt.setInt(2, solicitacaoVaga.getIdViagem());

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
    public List<SolicitacaoVaga> listar() {
        String sql = "SELECT * FROM SolicitacaoVaga;";
        List<SolicitacaoVaga> solicitacoes = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SolicitacaoVaga solicitacao = new SolicitacaoVaga(
                        rs.getString("EmailPassageiro"),
                        rs.getInt("IdViagem")
                );

                solicitacoes.add(solicitacao);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return solicitacoes;
    }

    /* CONCIDERADO DESNECESSARIO
        E desnecessario pois uma soliciatacao possui apenas o email do passageiro
        e o id da viagem, se eles forem modificados o proprio banco deve atualizar essa
        tabela.
    public boolean atualizar() {}
    */

    @Override
    public boolean deletar(SolicitacaoVaga solicitacao) {
        String sql = "DELETE FROM SolicitacaoVaga WHERE EmailPassageiro ILIKE ? " +
                "AND IdViagem = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, solicitacao.getEmailPassageiro());
            stmt.setInt(2, solicitacao.getIdViagem());

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
    public List<SolicitacaoVaga> listarById(int idViagem) {
        String sql = "SELECT * FROM SolicitacaoVaga WHERE idviagem = ?;";
        List<SolicitacaoVaga> solicitacoes = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idViagem);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SolicitacaoVaga solicitacao = new SolicitacaoVaga(
                        rs.getString("EmailPassageiro"),
                        rs.getInt("IdViagem")
                );

                solicitacoes.add(solicitacao);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return solicitacoes;
    }
}
