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

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    private TransferenciasDao transferenciaDao;

    @Override
    public void init() throws ServletException {
        // Inicializa o DAO como uma instância de OracleTransferenciaDao
        transferenciaDao = new OracleTransferenciasDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Busca as últimas 5 transferências usando o DAO
        List<Transferencias> ultimasTransferencias = transferenciaDao.getUltimasTransferencias(5);

        // Define o atributo para o JSP
        request.setAttribute("ultimasTransferencias", ultimasTransferencias);

        // Encaminha para o JSP que exibirá os dados
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);

    }
}
