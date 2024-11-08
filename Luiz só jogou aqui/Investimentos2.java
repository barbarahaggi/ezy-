package br.com.fiap.fintech.servlet;

import br.com.fiap.fintech.dao.InvestimentoDao;
import br.com.fiap.fintech.model.RendimentoDiario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/graficoRendimento")
public class GraficoRendimentoServlet extends HttpServlet {

    private InvestimentoDao investimentoDao;

    @Override
    public void init() throws ServletException {
        investimentoDao = new InvestimentoDao(); // Inicialização do DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Busca dados de rendimento diário para o gráfico
        List<RendimentoDiario> rendimentoDiario = investimentoDao.getRendimentoDiario();

        // Define o atributo para o JSP
        request.setAttribute("rendimentoDiario", rendimentoDiario);

        // Encaminha para o JSP que exibirá o gráfico
        RequestDispatcher dispatcher = request.getRequestDispatcher("graficoRendimento.jsp");
        dispatcher.forward(request, response);
    }
}
