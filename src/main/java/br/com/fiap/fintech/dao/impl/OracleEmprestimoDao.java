package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.EmprestimoDao;
import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Emprestimo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleEmprestimoDao implements EmprestimoDao {
    private Connection conexao;

    @Override
    public void cadastrar(Emprestimo emprestimo) throws DBException {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO EMPRESTIMO (ID_EMPRE, VALOR, DATA_INICIO, DATA_VENCIMENTO, TAXA_JUROS, CLIENTE_ID_CLIENTE" +
                "VALUES (sequencia, ?, ?, ?, ?, ?";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, emprestimo.getValor());
            stmt.setDate(2, Date.valueOf(emprestimo.getData_inicio()));
            stmt.setDate(3, Date.valueOf(emprestimo.getData_vencimento()));
            stmt.setDouble(4, emprestimo.getTaxa_juros());
            stmt.setInt(5, emprestimo.getCliente_id_cliente());
            stmt.executeUpdate();
            System.out.println("Cadastro realizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Emprestimo emprestimo) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE EMPRESTIMO SET" +
                    "VALOR = ?," +
                    "DATA_INICIO = ?," +
                    "DATA_VENCIMENTO = ?," +
                    "TAXA_JUROS = ?," +
                    "CLIENTE_ID_CLIENTE = ?" +
                    "WHERE ID_EMPRE = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, emprestimo.getValor());
            stmt.setDate(2, Date.valueOf(emprestimo.getData_inicio()));
            stmt.setDate(3, Date.valueOf(emprestimo.getData_vencimento()));
            stmt.setDouble(4, emprestimo.getTaxa_juros());
            stmt.setInt(5, emprestimo.getCliente_id_cliente());
            stmt.setInt(6, emprestimo.getId_empre());
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remover(int id) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM EMPRESTIMO WHERE ID_EMPRE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Removido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Emprestimo buscar(int id) {
        Emprestimo emprestimo = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM EMPRESTIMO WHERE ID_EMPRE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int codigoRetornado = rs.getInt("ID_EMPRE");
                double valor = rs.getDouble("VALOR");
                LocalDate data_inicio = rs.getDate("DATA_INICIO").toLocalDate();
                LocalDate data_vencimento = rs.getDate("DATA_VENCIMENTO").toLocalDate();
                double taxa_juros = rs.getDouble("TAXA_JUROS");
                int cliente_id_cliente = rs.getInt("CLIENTE_ID_CLIENTE");

                emprestimo = new Emprestimo(codigoRetornado, valor, data_inicio, data_vencimento, taxa_juros, cliente_id_cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emprestimo;
    }

    @Override
    public List<Emprestimo> listar() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM EMPRESTIMO";
            stmt = conexao.prepareStatement(sql);
            rs =stmt.executeQuery();

            while (rs.next()) {
                int codigoRetornado = rs.getInt("ID_EMPRE");
                double valor = rs.getDouble("VALOR");
                LocalDate data_inicio = rs.getDate("DATA_INICIO").toLocalDate();
                LocalDate data_vencimento = rs.getDate("DATA_VENCIMENTO").toLocalDate();
                double taxa_juros = rs.getDouble("TAXA_JUROS");
                int cliente_id_cliente = rs.getInt("CLIENTE_ID_CLIENTE");

                Emprestimo emprestimo = new Emprestimo(codigoRetornado, valor, data_inicio, data_vencimento, taxa_juros, cliente_id_cliente);
                emprestimos.add(emprestimo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emprestimos;
    }
}
