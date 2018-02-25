package io.github.sisRide.dao.postgres;

import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.vaga.SolicitacaoVaga;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoVagaDaoPostgres {

    private final Connection conn;

    public SolicitacaoVagaDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    public boolean salvar(SolicitacaoVaga solicitacaoVaga) {
        String sql = "INSERT INTO SolicatacaoVaga(EmailPassageiro, IdViagem) VALUES (?,?)";

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
}
