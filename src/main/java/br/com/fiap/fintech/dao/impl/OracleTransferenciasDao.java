package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.TransferenciasDao;
import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Transferencias;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleTransferenciasDao implements TransferenciasDao {
    private Connection conexao;

    @Override
    public void cadastrar(Transferencias transferencias) throws DBException {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO TRANSFERENCIAS (ID_TRANSFE, RECEITAS, DESPESAS, CLIENTE_ID_CLIENTE)" +
                "VALUES (sequencia, ?, ?, ?)";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, transferencias.getReceitas());
            stmt.setDouble(2, transferencias.getDespesas());
            stmt.setInt(3, transferencias.getCliente_id_cliente());
            stmt.executeUpdate();
            System.out.println("Cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Transferencias transferencias) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE TRANSFERENCIAS SET" +
                    "RECEITAS = ?," +
                    "DESPESAS = ?," +
                    "CLIENTE_ID_CLIENTE = ?" +
                    "WHERE ID_TRANSFE = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, transferencias.getReceitas());
            stmt.setDouble(2, transferencias.getDespesas());
            stmt.setInt(3, transferencias.getCliente_id_cliente());
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remover(int id) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM TRANSFERENCIAS WHERE ID_TRANSFE = ?";
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Transferencias buscar(int id) {
        Transferencias transferencias = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TRANSFERENCIAS WHERE ID_TRANSFE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int codigoRetornado = rs.getInt("ID_TRANSFE");
                double receitas = rs.getDouble("RECEITAS");
                double despesas = rs.getDouble("DESPESAS");
                int cliente_id_cliente = rs.getInt("CLIENTE_ID_CLIENTE");

                transferencias = new Transferencias(codigoRetornado, receitas, despesas, cliente_id_cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return transferencias;
    }

    @Override
    public List<Transferencias> listar() {
        List<Transferencias> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TRANSFERENCIAS";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigoRetornado = rs.getInt("ID_TRANSFE");
                double receitas = rs.getDouble("RECEITAS");
                double despesas = rs.getDouble("DESPESAS");
                int cliente_id_cliente = rs.getInt("CLIENTE_ID_CLIENTE");

                Transferencias transferencias = new Transferencias(codigoRetornado, receitas, despesas, cliente_id_cliente);
                lista.add(transferencias);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}
