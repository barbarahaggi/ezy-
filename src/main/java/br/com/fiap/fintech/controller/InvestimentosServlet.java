package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.InvestimentoDao;
import br.com.fiap.fintech.dao.impl.OracleInvestimentoDao;
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.exception.DBException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/investimentos")
public class InvestimentosServlet extends HttpServlet {

    private InvestimentoDao investimentoDao;

    @Override
    public void init() throws ServletException {
        // Inicializa o DAO como uma instância de OracleInvestimentoDao
        investimentoDao = new OracleInvestimentoDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Exceção tratada ao tentar buscar investimentos
        try {
            // Busca todos os investimentos usando o DAO
            List<Investimento> investimentos = investimentoDao.listar();

            // Define o atributo para o JSP
            request.setAttribute("investimentos", investimentos);

            // Encaminha para o JSP que exibirá os dados
            RequestDispatcher dispatcher = request.getRequestDispatcher("investimentos.jsp");
            dispatcher.forward(request, response);
        } catch (DBException e) {
            // Em caso de erro no banco de dados, loga e encaminha para uma página de erro
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erro ao listar investimentos.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
