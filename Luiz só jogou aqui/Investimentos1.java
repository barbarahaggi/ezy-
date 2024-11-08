package br.com.fiap.fintech.servlet;

import br.com.fiap.fintech.dao.InvestimentoDao;
import br.com.fiap.fintech.model.Investimento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/investimentos")
public class InvestimentosServlet extends HttpServlet {

    private InvestimentoDao investimentoDao;

    @Override
    public void init() throws ServletException {
        investimentoDao = new InvestimentoDao(); // Inicialização do DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Busca todos os investimentos
        List<Investimento> investimentos = investimentoDao.getAllInvestimentos();

        // Define o atributo para o JSP
        request.setAttribute("investimentos", investimentos);

        // Encaminha para o JSP que exibirá os dados
        RequestDispatcher dispatcher = request.getRequestDispatcher("investimentos.jsp");
        dispatcher.forward(request, response);
    }
}
