package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ClienteDao;
import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Cliente;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleClienteDao implements ClienteDao {
    private Connection conexao;

    @Override
    public void cadastrar(Cliente cliente) throws DBException {

        PreparedStatement stmt = null;
        conexao = ConnectionManager.getInstance().getConnection();

        String sql ="INSERT INTO CLIENTE (ID_CLIENTE, NOME, CPF, RG, DATA_NASCIMENTO, TELEFONEL)" +
                "VALUES (ID_CLIENTE, ?, ?, ?, ?, ?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setDate(4, Date.valueOf(cliente.getData_nascimento()));
            stmt.setString(5, cliente.getTelefone());
            stmt.executeUpdate();
            System.out.println("Cadastro realizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Cliente cliente) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE CLIENTE SET" +
                    "NOME = ?," +
                    "CPF = ?," +
                    "RG = ?," +
                    "DATA_NASCIMENTO = ?," +
                    "TELEFONEL = ?" +
                    "WHERE ID_CLIENTE = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setDate(4, Date.valueOf(cliente.getData_nascimento()));
            stmt.setString(5, cliente.getTelefone());
            stmt.setInt(6, cliente.getId_cliente());
            stmt.executeUpdate();
            System.out.println("Dados atualizados!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
                stmt.close();
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

            String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Remoção realizada com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Cliente buscar(int id) {
        Cliente cliente = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int codigoRetornado = rs.getInt("ID_CLIENTE");
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF");
                String rg = rs.getString("RG");
                LocalDate data_nascimento = rs.getDate("DATA_NASCIMENTO").toLocalDate();
                String telefone = rs.getString("TELEFONEL");

                cliente = new Cliente(codigoRetornado, nome, cpf, rg, telefone, data_nascimento);
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
        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM CLIENTE";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigoRetornado = rs.getInt("ID_CLIENTE");
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF");
                String rg = rs.getString("RG");
                LocalDate data_nascimento = rs.getDate("DATA_NASCIMENTO").toLocalDate();
                String telefone = rs.getString("TELEFONEL");

                Cliente cliente = new Cliente(codigoRetornado, nome, cpf, rg, telefone, data_nascimento);
                clientes.add(cliente);
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
        return clientes;
    }
}
