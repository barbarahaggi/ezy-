import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// Imports para os DAOs e modelos
import br.com.fiap.fintech.dao.TransferenciaDao;
import br.com.fiap.fintech.dao.InvestimentoDao;
import br.com.fiap.fintech.model.Transferencia;
import br.com.fiap.fintech.model.Investimento;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    // Inicializa as classes DAO para Transferencia e Investimento
    private TransferenciaDao transferenciaDao = new TransferenciaDaoImpl();
    private InvestimentoDao investimentoDao = new InvestimentoDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configura o tipo de conteúdo da resposta
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtém o nome do usuário (supõe-se que o nome está na sessão)
        String nomeUsuario = (String) request.getSession().getAttribute("nomeUsuario");

        // Busca os últimos 5 registros das tabelas Transferencias e Investimentos
        List<Transferencia> ultimasTransferencias = transferenciaDao.getUltimasTransferencias(5);
        List<Investimento> ultimosInvestimentos = investimentoDao.getUltimosInvestimentos(5);

        // Gera o HTML para a página
        out.println("<html><body>");
        out.println("<h2>Dashboard do Usuário</h2>");

        // Exibe as últimas 5 transferências
        out.println("<h3>Últimas Transferências</h3>");
        if (ultimasTransferencias != null && !ultimasTransferencias.isEmpty()) {
            out.println("<ul>");
            for (Transferencia transferencia : ultimasTransferencias) {
                out.println("<li>" + transferencia.toString() + "</li>"); // Exibe as informações da transferência
            }
            out.println("</ul>");
        } else {
            out.println("<p>Nenhuma transferência encontrada.</p>");
        }

        // Exibe os últimos 5 investimentos
        out.println("<h3>Últimos Investimentos</h3>");
        if (ultimosInvestimentos != null && !ultimosInvestimentos.isEmpty()) {
            out.println("<ul>");
            for (Investimento investimento : ultimosInvestimentos) {
                out.println("<li>" + investimento.toString() + "</li>"); // Exibe as informações do investimento
            }
            out.println("</ul>");
        } else {
            out.println("<p>Nenhum investimento encontrado.</p>");
        }

        // Botão para exibir o nome do usuário e redirecionar para a página de perfil
        out.println("<form action='PerfilServlet' method='GET'>");
        out.println("<button type='submit'>Perfil de " + nomeUsuario + "</button>");
        out.println("</form>");

        out.println("</body></html>");
    }
}
