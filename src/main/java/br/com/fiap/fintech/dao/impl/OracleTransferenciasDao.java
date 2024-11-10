package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.TransferenciasDao;
import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Transferencias;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleTransferenciasDao implements TransferenciasDao {

    @Override
    public void cadastrar(Transferencias transferencias) throws DBException {
        String sql = "INSERT INTO TRANSFERENCIAS (VALOR, DATA, TIPO) VALUES (?, ?, ?)";
        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setDouble(1, transferencias.getValor());
            stmt.setDate(2, transferencias.getData());  // Usando java.sql.Date diretamente
            stmt.setString(3, transferencias.getTipo());
            stmt.executeUpdate();
            System.out.println("Cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar transferência", e);
        }
    }

    @Override
    public void atualizar(Transferencias transferencias) throws DBException {
        String sql = "UPDATE TRANSFERENCIAS SET VALOR = ?, DATA = ?, TIPO = ? WHERE ID_TRANSF = ?";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setDouble(1, transferencias.getValor());
            stmt.setDate(2, transferencias.getData());  // Usando java.sql.Date diretamente
            stmt.setString(3, transferencias.getTipo());
            stmt.setInt(4, transferencias.getIdTransf());
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar transferência", e);
        }
    }

    @Override
    public void remover(int id) throws DBException {
        String sql = "DELETE FROM TRANSFERENCIAS WHERE ID_TRANSF = ?";
        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Removido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover transferência", e);
        }
    }

    @Override
    public Transferencias buscar(int id) {
        String sql = "SELECT * FROM TRANSFERENCIAS WHERE ID_TRANSF = ?";
        Transferencias transferencias = null;

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int codigoRetornado = rs.getInt("ID_TRANSF");
                    double valor = rs.getDouble("VALOR");
                    java.sql.Date data = rs.getDate("DATA");  // Usando java.sql.Date diretamente
                    String tipo = rs.getString("TIPO");

                    transferencias = new Transferencias(codigoRetornado, valor, data, tipo);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar transferência", e);
        }
        return transferencias;
    }

    @Override
    public List<Transferencias> listar() {
        String sql = "SELECT * FROM TRANSFERENCIAS";
        List<Transferencias> lista = new ArrayList<>();

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigoRetornado = rs.getInt("ID_TRANSF");
                double valor = rs.getDouble("VALOR");
                java.sql.Date data = rs.getDate("DATA");  // Usando java.sql.Date diretamente
                String tipo = rs.getString("TIPO");

                Transferencias transferencias = new Transferencias(codigoRetornado, valor, data, tipo);
                lista.add(transferencias);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar transferências", e);
        }
        return lista;
    }

    @Override
    public List<Transferencias> getTransferenciasPaginated(int start, int recordsPerPage) {
        String sql = "SELECT * FROM TRANSFERENCIAS ORDER BY ID_TRANSF OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Transferencias> lista = new ArrayList<>();

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, start);
            stmt.setInt(2, recordsPerPage);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int codigoRetornado = rs.getInt("ID_TRANSF");
                    double valor = rs.getDouble("VALOR");
                    java.sql.Date data = rs.getDate("DATA");  // Usando java.sql.Date diretamente
                    String tipo = rs.getString("TIPO");

                    Transferencias transferencias = new Transferencias(codigoRetornado, valor, data, tipo);
                    lista.add(transferencias);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar transferências paginadas", e);
        }
        return lista;
    }

    @Override
    public List<Transferencias> getUltimasTransferencias(int limit) {
        String sql = "SELECT * FROM TRANSFERENCIAS ORDER BY DATA DESC FETCH FIRST ? ROWS ONLY";
        List<Transferencias> lista = new ArrayList<>();

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, limit);  // Define o número de transferências a serem retornadas

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int codigoRetornado = rs.getInt("ID_TRANSF");
                    double valor = rs.getDouble("VALOR");
                    java.sql.Date data = rs.getDate("DATA");  // Usando java.sql.Date diretamente
                    String tipo = rs.getString("TIPO");

                    Transferencias transferencias = new Transferencias(codigoRetornado, valor, data, tipo);
                    lista.add(transferencias);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar últimas transferências", e);
        }
        return lista;
    }

}
