package br.com.fiap.fintech.servlet;

import br.com.fiap.fintech.dao.TransferenciaDao;
import br.com.fiap.fintech.model.Transferencia;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/transferencias")
public class TransferenciasServlet extends HttpServlet {

    private static final int RECORDS_PER_PAGE = 30;
    private TransferenciaDao transferenciaDao;

    @Override
    public void init() throws ServletException {
        transferenciaDao = new TransferenciaDao(); // Inicialize o DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        // Calcula o offset e busca os registros limitados pelo número de registros por página
        int start = (page - 1) * RECORDS_PER_PAGE;
        List<Transferencia> transferencias = transferenciaDao.getTransferenciasPaginated(start, RECORDS_PER_PAGE);

        // Obtém o número total de registros para calcular o número de páginas
        int totalRecords = transferenciaDao.getTotalRecords();
        int totalPages = (int) Math.ceil((double) totalRecords / RECORDS_PER_PAGE);

        // Define atributos para o JSP
        request.setAttribute("transferencias", transferencias);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        // Encaminha para o JSP que exibirá os registros
        RequestDispatcher dispatcher = request.getRequestDispatcher("transferencias.jsp");
        dispatcher.forward(request, response);
    }
}
