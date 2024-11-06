package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.TransferenciaDao;
import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.model.Transferencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleTransferenciaDao implements TransferenciaDao {
    private Connection conexao;

    @Override
    public void insert(Transferencia transferencia) {
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "INSERT INTO transferencia (DESPESAS, RECEITA, ID_USER, ID_CONTA) VALUES (?, ?, ?, ?)";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, transferencia.getDespesas());
            stmt.setDouble(2, transferencia.getReceita());
            stmt.setInt(3, transferencia.getId_user());
            stmt.setInt(4, transferencia.getId_conta());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir a transferência", e);
        } finally {
            closeConnection(conexao);
        }
    }

    @Override
    public Transferencia getById(int id) {
        conexao = ConnectionManager.getInstance().getConnection();
        Transferencia transferencia = null;

        String sql = "SELECT * FROM transferencia WHERE ID_TRANSFERENCIA = ?";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                transferencia = new Transferencia(
                        rs.getDouble("DESPESAS"),
                        rs.getDouble("RECEITA"),
                        rs.getInt("ID_USER"),
                        rs.getInt("ID_CONTA")
                );
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar a transferência por ID", e);
        } finally {
            closeConnection(conexao);
        }
        return transferencia;
    }

    @Override
    public List<Transferencia> getAll() {
        conexao = ConnectionManager.getInstance().getConnection();
        List<Transferencia> transferencias = new ArrayList<>();

        String sql = "SELECT * FROM transferencia";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Transferencia transferencia = new Transferencia(
                        rs.getDouble("DESPESAS"),
                        rs.getDouble("RECEITA"),
                        rs.getInt("ID_USER"),
                        rs.getInt("ID_CONTA")
                );
                transferencias.add(transferencia);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar as transferências", e);
        } finally {
            closeConnection(conexao);
        }
        return transferencias;
    }

    @Override
    public void update(Transferencia transferencia) {
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "UPDATE transferencia SET DESPESAS = ?, RECEITA = ?, ID_USER = ?, ID_CONTA = ? WHERE ID_TRANSFERENCIA = ?";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, transferencia.getDespesas());
            stmt.setDouble(2, transferencia.getReceita());
            stmt.setInt(3, transferencia.getId_user());
            stmt.setInt(4, transferencia.getId_conta());
            stmt.setInt(5, transferencia.getId_user()); // Ajuste conforme necessário para identificar a transferência
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar a transferência", e);
        } finally {
            closeConnection(conexao);
        }
    }

    @Override
    public void delete(int id) {
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "DELETE FROM transferencia WHERE ID_TRANSFERENCIA = ?";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar a transferência", e);
        } finally {
            closeConnection(conexao);
        }
    }

    private void closeConnection(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", e);
            }
        }
    }
}
