//package br.com.fiap.fintech.dao.impl;
//
//import br.com.fiap.fintech.dao.ConnectionManager;
//import br.com.fiap.fintech.exception.DBException;
//import br.com.fiap.fintech.model.Investimento;
//import br.com.fiap.fintech.dao.InvestimentoDao;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OracleInvestimentoDao implements InvestimentoDao {
//    private Connection conexao;
//
//    @Override
//    public void cadastrar(Investimento investimento) throws DBException {
//        PreparedStatement stmt = null;
//
//        String sql = "INSERT INTO INVESTIMENTO (ID_INVEST, CDI, VALOR, CLIENTE_ID_CLIENTE)" +
//                "VALUES (sequencia, ?, ?, ?)";
//
//        try {
//            conexao = ConnectionManager.getInstance().getConnection();
//            stmt = conexao.prepareStatement(sql);
//            stmt.setDouble(1, investimento.getCdi());
//            stmt.setDouble(2, investimento.getValor());
//            stmt.setInt(3, investimento.getCliente_id_cliente());
//            stmt.executeUpdate();
//            System.out.println("Cadastrado com sucesso!");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                stmt.close();
//                conexao.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public void atualizar(Investimento investimento) throws DBException {
//        PreparedStatement stmt = null;
//
//        try {
//            conexao = ConnectionManager.getInstance().getConnection();
//
//            String sql = "UPDATE INVESTIMENTO SET" +
//                    "CDI = ?," +
//                    "VALOR = ?," +
//                    "CLIENTE_ID_CLIENTE = ?" +
//                    "WHERE ID_INVEST = ?";
//
//            stmt = conexao.prepareStatement(sql);
//            stmt.setDouble(1, investimento.getIdInvest());
//            stmt.setDouble(2, investimento.getValor());
//            stmt.executeUpdate();
//            System.out.println("Atualizado com sucesso!");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                stmt.close();
//                conexao.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public void remover(int id) throws DBException {
//        PreparedStatement stmt = null;
//
//        try {
//            conexao = ConnectionManager.getInstance().getConnection();
//
//            String sql = "DELETE FROM INVESTIMENTO WHERE ID_INVEST = ?";
//            stmt = conexao.prepareStatement(sql);
//            stmt.setInt(1, id);
//            stmt.executeUpdate();
//            System.out.println("Removido com sucesso!");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                stmt.close();
//                conexao.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public Investimento buscar(int id) {
//        Investimento investimento = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            conexao = ConnectionManager.getInstance().getConnection();
//            String sql = "SELECT * FROM INVESTIMENTO WHERE ID_INVEST = ?";
//            stmt = conexao.prepareStatement(sql);
//            stmt.setInt(1, id);
//            rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                int codigoRetornado = rs.getInt("ID_INVEST");
//                double cdi = rs.getDouble("CDI");
//                double valor = rs.getDouble("VALOR");
//                int cliente_id_cliente = rs.getInt("CLIENTE_ID_CLIENTE");
//
//                investimento = new Investimento(codigoRetornado, cdi, valor, cliente_id_cliente);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                stmt.close();
//                rs.close();
//                conexao.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return investimento;
//    }
//
//    @Override
//    public List<Investimento> listar() {
//        List<Investimento> investimentos = new ArrayList<>();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            conexao = ConnectionManager.getInstance().getConnection();
//            String sql = "SELECT * FROM INVESTIMENTO";
//            stmt = conexao.prepareStatement(sql);
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                int codigoRetornado = rs.getInt("ID_INVEST");
//                double cdi = rs.getDouble("CDI");
//                double valor = rs.getDouble("VALOR");
//                int cliente_id_cliente = rs.getInt("CLIENTE_ID_CLIENTE");
//
//                Investimento investimento = new Investimento(codigoRetornado, cdi, valor, cliente_id_cliente);
//                investimentos.add(investimento);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                stmt.close();
//                rs.close();
//                conexao.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return investimentos;
//    }
//}
