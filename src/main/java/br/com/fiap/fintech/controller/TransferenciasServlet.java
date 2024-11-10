package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.TransferenciasDao;
import br.com.fiap.fintech.dao.impl.OracleTransferenciasDao;
import br.com.fiap.fintech.model.Transferencias;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/transferencias")
public class TransferenciasServlet extends HttpServlet {

    private static final int RECORDS_PER_PAGE = 30;
    private TransferenciasDao transferenciaDao;

    @Override
    public void init() throws ServletException {
        // Inicializa o DAO com uma instância de OracleTransferenciasDao
        transferenciaDao = new OracleTransferenciasDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        // Calcula o offset e busca os registros limitados pelo número de registros por página
        int start = (page - 1) * RECORDS_PER_PAGE;
        List<Transferencias> transferencias = transferenciaDao.getTransferenciasPaginated(start, RECORDS_PER_PAGE);

        // Obtém o número total de registros para calcular o número de páginas
        int totalRecords = transferenciaDao.listar().size(); // Obtém a quantidade de registros na lista
        int totalPages = (int) Math.ceil((double) totalRecords / RECORDS_PER_PAGE);

        // Define atributos para o JSP
        request.setAttribute("transferencias", transferencias);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        // Encaminha para o JSP que exibirá os registros
        RequestDispatcher dispatcher = request.getRequestDispatcher("extrato.jsp");
        dispatcher.forward(request, response);
    }
}
