package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.EmprestimoDao;
import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.model.Emprestimo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleEmprestimoDao implements EmprestimoDao {
    private Connection conexao;

    @Override
    public void insert(Emprestimo emprestimo) {
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "INSERT INTO emprestimo (ID_EMPRESTIMO, ID_USER, VALOR, DATA_INICIO, DATA_VENCIMENTO, TAXA_JUROS) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, emprestimo.getId_emprestimo());
            stmt.setInt(2, emprestimo.getId_user());
            stmt.setDouble(3, emprestimo.getValor());
            stmt.setDate(4, Date.valueOf(emprestimo.getData_inicio()));
            stmt.setDate(5, Date.valueOf(emprestimo.getData_vencimento()));
            stmt.setDouble(6, emprestimo.getTaxa_juros());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir o empréstimo", e);
        } finally {
            closeConnection(conexao);
        }
    }

    @Override
    public Emprestimo getById(int id) {
        conexao = ConnectionManager.getInstance().getConnection();
        Emprestimo emprestimo = null;

        String sql = "SELECT * FROM emprestimo WHERE ID_EMPRESTIMO = ?";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                emprestimo = new Emprestimo(
                        rs.getInt("ID_EMPRESTIMO"),
                        rs.getInt("ID_USER"),
                        rs.getDouble("VALOR"),
                        rs.getDate("DATA_INICIO").toLocalDate(),
                        rs.getDate("DATA_VENCIMENTO").toLocalDate(),
                        rs.getDouble("TAXA_JUROS")
                );
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar o empréstimo por ID", e);
        } finally {
            closeConnection(conexao);
        }
        return emprestimo;
    }

    @Override
    public List<Emprestimo> getAll() {
        conexao = ConnectionManager.getInstance().getConnection();
        List<Emprestimo> emprestimos = new ArrayList<>();

        String sql = "SELECT * FROM emprestimo";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo(
                        rs.getInt("ID_EMPRESTIMO"),
                        rs.getInt("ID_USER"),
                        rs.getDouble("VALOR"),
                        rs.getDate("DATA_INICIO").toLocalDate(),
                        rs.getDate("DATA_VENCIMENTO").toLocalDate(),
                        rs.getDouble("TAXA_JUROS")
                );
                emprestimos.add(emprestimo);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar os empréstimos", e);
        } finally {
            closeConnection(conexao);
        }
        return emprestimos;
    }

    @Override
    public void update(Emprestimo emprestimo) {
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "UPDATE emprestimo SET ID_USER = ?, VALOR = ?, DATA_INICIO = ?, DATA_VENCIMENTO = ?, TAXA_JUROS = ? WHERE ID_EMPRESTIMO = ?";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, emprestimo.getId_user());
            stmt.setDouble(2, emprestimo.getValor());
            stmt.setDate(3, Date.valueOf(emprestimo.getData_inicio()));
            stmt.setDate(4, Date.valueOf(emprestimo.getData_vencimento()));
            stmt.setDouble(5, emprestimo.getTaxa_juros());
            stmt.setInt(6, emprestimo.getId_emprestimo());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar o empréstimo", e);
        } finally {
            closeConnection(conexao);
        }
    }

    @Override
    public void delete(int id) {
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "DELETE FROM emprestimo WHERE ID_EMPRESTIMO = ?";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar o empréstimo", e);
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
