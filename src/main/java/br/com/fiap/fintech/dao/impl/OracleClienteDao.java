package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ClienteDao;
import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleClienteDao implements ClienteDao {

    @Override
    public void insert(Cliente cliente) {
        Connection conexao = null;
        String sql = "INSERT INTO cliente (ID_CLIENTE, NOME, CPF, RG, EMAIL, TELEFONE, NASC) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cliente.getId_cliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRg());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getTelefone());
            stmt.setDate(7, Date.valueOf(cliente.getNasc()));
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir o cliente", e);
        } finally {
            closeConnection(conexao);
        }
    }

    @Override
    public Cliente getById(int id) {
        Connection conexao = null;
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE ID_CLIENTE = ?";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                        rs.getInt("ID_CLIENTE"),
                        rs.getString("NOME"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("EMAIL"),
                        rs.getString("TELEFONE"),
                        rs.getDate("NASC").toLocalDate()
                );
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar o cliente por ID", e);
        } finally {
            closeConnection(conexao);
        }
        return cliente;
    }

    @Override
    public List<Cliente> getAll() {
        Connection conexao = null;
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("ID_CLIENTE"),
                        rs.getString("NOME"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("EMAIL"),
                        rs.getString("TELEFONE"),
                        rs.getDate("NASC").toLocalDate()
                );
                clientes.add(cliente);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar os clientes", e);
        } finally {
            closeConnection(conexao);
        }
        return clientes;
    }

    @Override
    public void update(Cliente cliente) {
        Connection conexao = null;
        String sql = "UPDATE cliente SET NOME = ?, CPF = ?, RG = ?, EMAIL = ?, TELEFONE = ?, NASC = ? WHERE ID_CLIENTE = ?";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefone());
            stmt.setDate(6, Date.valueOf(cliente.getNasc()));
            stmt.setInt(7, cliente.getId_cliente());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar o cliente", e);
        } finally {
            closeConnection(conexao);
        }
    }

    @Override
    public void delete(int id) {
        Connection conexao = null;
        String sql = "DELETE FROM cliente WHERE ID_CLIENTE = ?";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar o cliente", e);
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
