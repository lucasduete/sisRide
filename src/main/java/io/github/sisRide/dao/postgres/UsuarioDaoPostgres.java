package io.github.sisRide.dao.postgres;

import io.github.sisRide.dao.interfaces.UsuarioDaoInterface;
import io.github.sisRide.exceptions.CredenciaisInvalidasException;
import io.github.sisRide.factory.Conexao;
import io.github.sisRide.model.Usuario;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoPostgres implements UsuarioDaoInterface {

    private final Connection conn;

    public UsuarioDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
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
            stmt.setString(6, usuario.getSexo());
            stmt.setDate(7, Date.valueOf(usuario.getDataNasc()));
            stmt.setString(8, usuario.getProfissao());
            stmt.setString(9, usuario.getCidade());
            stmt.setString(10, usuario.getTipo());

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
    public List<Usuario> listar() {
        String sql = "SELECT * FROM Usuario;";
        List<Usuario> usuarios = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Date data = rs.getDate("dataNasc");
                Instant instant = Instant.ofEpochMilli(data.getTime());

                Usuario usuario = new Usuario(
                        rs.getString("email"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getFloat("nota"),
                        rs.getString("fotoPerfil"),
                        rs.getString("sexo"),
                        LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate(),
                        rs.getString("profissao"),
                        rs.getString("cidade"),
                        rs.getString("tipo")
                );

                usuarios.add(usuario);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return usuarios;
    }

    @Override
    public boolean atualizar(Usuario usuario) {

        String sql = "UPDATE Usuario SET Email = ?, Nome = ?, Senha = ?, Nota = ?, fotoPerfil = ?, " +
                "sexo = ?, dataNasc = ?, profissao = ?, cidade = ?, tipo = ? WHERE Email = ?";

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
            stmt.setString(10, usuario.getEmail());

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
    public boolean deletar(Usuario usuario) {

        String sql = "DELETE FROM Carro WHERE EmailMotorista = ?;" +
                "DELETE FROM Lugar WHERE EmailUsuario = ?;" +
                "DELETE FROM Viagem WHERE EmailMotorista = ?;" +
                "DELETE FROM Follow WHERE EmailSeguidor = ?;" +
                "DELETE FROM Follow WHERE EmailSeguindo = ?;" +
                "DELETE FROM Friendship WHERE EmailUsuario = ?;" +
                "DELETE FROM Friendship WHERE EmailAmigo = ?;" +
                "DELETE FROM Message WHERE EmailEmissor = ?;" +
                "DELETE FROM Message WHERE EmailDestinatario = ?;" +
                "DELETE FROM Rating WHERE EmailMotorista = ?;" +
                "DELETE FROM Rating WHERE EmailPassageiro = ?;" +
                "DELETE FROM Publication WHERE EmailUsuario = ?;" +
                "DELETE FROM RequestFollow WHERE EmailSeguidor = ?;" +
                "DELETE FROM RequestFollow WHERE EmailSeguindo = ?;" +
                "DELETE FROM RequestFriendship WHERE EmailUsuario = ?;" +
                "DELETE FROM RequestFriendship WHERE EmailAmigo = ?;" +
                "DELETE FROM Usuario WHERE Email = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getEmail());
            stmt.setString(8, usuario.getEmail());
            stmt.setString(9, usuario.getEmail());
            stmt.setString(10, usuario.getEmail());
            stmt.setString(11, usuario.getEmail());
            stmt.setString(12, usuario.getEmail());
            stmt.setString(13, usuario.getEmail());
            stmt.setString(14, usuario.getEmail());
            stmt.setString(15, usuario.getEmail());
            stmt.setString(16, usuario.getEmail());
            stmt.setString(17, usuario.getEmail());

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
    public boolean login(String email, String senha) {

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

    @Override
    public Usuario getUsuarioByEmail(String email) {
        String sql = "SELECT * FROM Usuario WHERE Email ILIKE ?;";
        Usuario usuario = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                usuario = new Usuario();

                Date data = rs.getDate("dataNasc");
                Instant instant = Instant.ofEpochMilli(data.getTime());

                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNota(rs.getFloat("nota"));
                usuario.setFotoPerfil(rs.getString("fotoPerfil"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setDataNasc(
                        LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()
                );
                usuario.setProfissao(rs.getString("profissao"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setTipo(rs.getString("tipo"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return usuario;
    }

    @Override
    public String getFotoPerfil(String emailUser) {
        return null;
    }
}
