package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.dao.UsuarioDao;
import br.com.fiap.fintech.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleUsuarioDao implements UsuarioDao {
    private Connection conexao;

    @Override
    public boolean validarUsuario(Usuario usuario) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM USUARIO " +
                    "WHERE EMAIL = ? AND SENHA = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
