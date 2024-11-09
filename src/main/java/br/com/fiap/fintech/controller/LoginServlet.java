package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.bo.EmailBo;
import br.com.fiap.fintech.dao.UsuarioDao;
import br.com.fiap.fintech.exception.EmailException;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Usuario;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDao dao;
    private EmailBo bo;

    public LoginServlet() {
        dao = DaoFactory.getUsuarioDao();
        bo = new EmailBo();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Usuario usuario = new Usuario(email, password);

        if (dao.validarUsuario(usuario)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", email);

            String mensagem = "Um login foi realizado na plataforma em" + LocalDate.now();
            req.getRequestDispatcher("home.jsp").forward(req, resp);
            try {
                bo.enviarEmail(email, "Login realizado", mensagem);
            } catch (EmailException e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("erro", "usuario e/ou senha invalido");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
