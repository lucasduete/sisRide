package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;
import io.github.sisRide.exceptions.CredenciaisInvalidasException;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Usuario;

import java.sql.*;

public class UsuarioDaoPostgres implements UsuarioDaoInterface {

    private final Connection conn;

    public UsuarioDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    public boolean salvar(Usuario usuario) {
        String sql = "INSERT INTO Usuario(Email, Nome, Senha, Nota, FotoPerfil, Sexo, " +
                "DataNasc, Profissao, Cidade, Tipo) VALUES (?,?,?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getSenha());
            stmt.setFloat(4, usuario.getNota());
            stmt.setString(5, usuario.getFotoPerfil());
            stmt.setDate(6, Date.valueOf(usuario.getDataNasc()));
            stmt.setString(7, usuario.getProfissao());
            stmt.setString(8, usuario.getCidade());
            stmt.setString(9, usuario.getTipo());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean login(String email, String senha) {

        String sql = "SELECT Senha FROM Usuario WHERE Email ILIKE ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (!rs.next())
                throw new CredenciaisInvalidasException("Email Nao Encontrado.");

            if (!(senha.equals(rs.getString("Senha"))))
                throw new CredenciaisInvalidasException("Senha Incorreta.");

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException | CredenciaisInvalidasException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
}
