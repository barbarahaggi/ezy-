package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.EmprestimoDao;
import br.com.fiap.fintech.dao.impl.OracleEmprestimoDao;
import br.com.fiap.fintech.model.Emprestimo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarEmprestimos")
public class ListarEmprestimosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instanciando o DAO
        EmprestimoDao emprestimoDao = new OracleEmprestimoDao();

        // Listando os empréstimos
        List<Emprestimo> emprestimos = emprestimoDao.listar();

        if (emprestimos != null && !emprestimos.isEmpty()) {
            // Passando a lista de empréstimos para a JSP
            request.setAttribute("emprestimos", emprestimos);
        } else {
            // Caso a lista esteja vazia ou nula, você pode configurar um erro ou mensagem.
            request.setAttribute("erro", "Nenhum empréstimo encontrado.");
        }

        // Redirecionando para a página JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("emprestimo.jsp");
        dispatcher.forward(request, response);
    }
}
