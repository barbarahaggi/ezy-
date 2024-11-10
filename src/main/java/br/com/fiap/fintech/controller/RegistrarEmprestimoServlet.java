package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.exception.DBException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;


@WebServlet("/RegistrarEmprestimoServlet")
public class RegistrarEmprestimoServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String valorEmprestimoParam = request.getParameter("valorEmprestimo");
            double valorEmprestimo = Double.parseDouble(valorEmprestimoParam);

            String dataEmprestimoStr = request.getParameter("dataEmprestimo");
            Date dataEmprestimo = Date.valueOf(dataEmprestimoStr);

            String taxaJurosParam = request.getParameter("taxaJuros");
            double taxaJuros = Double.parseDouble(taxaJurosParam);

            String dataVencimentoStr = request.getParameter("dataVencimento");
            Date dataVencimento = Date.valueOf(dataVencimentoStr);

            String sql = "INSERT INTO emprestimo (ID_EMPRE, valor, data_inicio, taxa_juros, data_vencimento) " +
                    "VALUES (EMP_SEQ.NEXTVAL, ?, ?, ?, ?)";

            try (Connection connection = ConnectionManager.getInstance().getConnection();
                 PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setDouble(1, valorEmprestimo);
                pstmt.setDate(2, new java.sql.Date(dataEmprestimo.getTime()));
                pstmt.setDouble(3, taxaJuros);
                pstmt.setDate(4, new java.sql.Date(dataVencimento.getTime()));

                pstmt.executeUpdate();

                request.getSession().setAttribute("mensagem", "Empréstimo Registrado com Sucesso!");
                response.sendRedirect(request.getContextPath() + "/listarEmprestimos");
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("erro", "Erro ao registrar o empréstimo! Por favor, valide os dados.");
                response.sendRedirect(request.getContextPath() + "/listarEmprestimos");

            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao processar os dados: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/listarEmprestimos");

        }
    }
}
