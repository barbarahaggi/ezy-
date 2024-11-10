package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.dao.InvestimentoDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleInvestimentoDao implements InvestimentoDao {
    private Connection conexao;

    @Override
    public void cadastrar(Investimento investimento) throws DBException {
        PreparedStatement stmt = null;

        // Corrigido para refletir a nova estrutura da tabela
        String sql = "INSERT INTO INVESTIMENTO (ID_INVEST, VALOR, DATA_INICIO, NOME_INVESTIMENTO, DATA_FIM) " +
                "VALUES (sequencia.NEXTVAL, ?, ?, ?, ?)";

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, investimento.getValor());
            stmt.setDate(2, investimento.getDataInicio());;  // Usando java.sql.Date
            stmt.setString(3, investimento.getNomeInvestimento());
            stmt.setDate(4, new java.sql.Date(investimento.getDataFim().getTime()));  // Usando java.sql.Date
            stmt.executeUpdate();
            System.out.println("Cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar investimento", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Investimento investimento) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            // Atualizado para refletir as novas colunas da tabela
            String sql = "UPDATE INVESTIMENTO SET " +
                    "VALOR = ?, DATA_INICIO = ?, NOME_INVESTIMENTO = ?, DATA_FIM = ? " +
                    "WHERE ID_INVEST = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, investimento.getValor());
            stmt.setDate(2, new java.sql.Date(investimento.getDataInicio().getTime()));  // Usando java.sql.Date
            stmt.setString(3, investimento.getNomeInvestimento());
            stmt.setDate(4, new java.sql.Date(investimento.getDataFim().getTime()));  // Usando java.sql.Date
            stmt.setInt(5, investimento.getIdInvest());
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar investimento", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
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

            String sql = "DELETE FROM INVESTIMENTO WHERE ID_INVEST = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Removido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover investimento", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Investimento buscar(int id) throws DBException {
        Investimento investimento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM INVESTIMENTO WHERE ID_INVEST = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int codigoRetornado = rs.getInt("ID_INVEST");
                double valor = rs.getDouble("VALOR");
                java.sql.Date dataInicio = rs.getDate("DATA_INICIO");  // Usando java.sql.Date
                String nomeInvestimento = rs.getString("NOME_INVESTIMENTO");
                java.sql.Date dataFim = rs.getDate("DATA_FIM");  // Usando java.sql.Date

                investimento = new Investimento(codigoRetornado, valor, dataInicio.toLocalDate(), nomeInvestimento, dataFim.toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao buscar investimento", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return investimento;
    }

    @Override
    public List<Investimento> listar() throws DBException {
        List<Investimento> investimentos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM INVESTIMENTO";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigoRetornado = rs.getInt("ID_INVEST");
                double valor = rs.getDouble("VALOR");
                java.sql.Date dataInicio = rs.getDate("DATA_INICIO");  // Usando java.sql.Date
                String nomeInvestimento = rs.getString("NOME_INVESTIMENTO");
                java.sql.Date dataFim = rs.getDate("DATA_FIM");  // Usando java.sql.Date

                Investimento investimento = new Investimento(codigoRetornado, valor, dataInicio.toLocalDate(), nomeInvestimento, dataFim.toLocalDate());
                investimentos.add(investimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao listar investimentos", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return investimentos;
    }

    @Override
    public List<Investimento> getUltimosInvestimentos(int limit) {
        List<Investimento> investimentos = new ArrayList<>();
        String sql = "SELECT * FROM INVESTIMENTO ORDER BY DATA_INICIO DESC FETCH FIRST ? ROWS ONLY";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Investimento investimento = new Investimento(
                        rs.getInt("ID_INVEST"),
                        rs.getDouble("VALOR"),
                        rs.getDate("DATA_INICIO").toLocalDate(),
                        rs.getString("NOME_INVESTIMENTO"),
                        rs.getDate("DATA_FIM").toLocalDate()
                );
                investimentos.add(investimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar os últimos investimentos", e);
        }
        return investimentos;
    }
}
