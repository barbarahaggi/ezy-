package br.com.fiap.fintech.controller;


import br.com.fiap.fintech.dao.EmprestimoDao;
import br.com.fiap.fintech.dao.impl.OracleEmprestimoDao;
import br.com.fiap.fintech.model.Emprestimo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarEmprestimos")
public class ListarEmprestimoServlet extends HttpServlet {

    private EmprestimoDao emprestimoDao;

    @Override
    public void init() throws ServletException {
        emprestimoDao = new OracleEmprestimoDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensagem = (String) request.getSession().getAttribute("mensagem");
        if (mensagem != null) {
            request.getSession().removeAttribute("mensagem");
            request.setAttribute("mensagem", mensagem);
        }


        List<Emprestimo> emprestimos = emprestimoDao.listar();
        request.setAttribute("emprestimos", emprestimos);
        request.getRequestDispatcher("emprestimo.jsp").forward(request, response);
    }
}
