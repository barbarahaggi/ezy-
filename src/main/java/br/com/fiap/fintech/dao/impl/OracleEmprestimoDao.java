// OracleEmprestimoDao.java
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

    }

    @Override
    public void atualizar(Emprestimo emprestimo) throws DBException {

    }

    @Override
    public void remover(int id) throws DBException {

    }

    @Override
    public Emprestimo buscar(int id) {
        return null;
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
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_EMPRE");
                double valor = rs.getDouble("VALOR");
                LocalDate dataInicio = rs.getDate("DATA_INICIO").toLocalDate();
                LocalDate dataVencimento = rs.getDate("DATA_VENCIMENTO").toLocalDate();
                double taxaJuros = rs.getDouble("TAXA_JUROS");

                Emprestimo emprestimo = new Emprestimo(id, valor, dataInicio, dataVencimento, taxaJuros);
                emprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emprestimos;
    }
}
