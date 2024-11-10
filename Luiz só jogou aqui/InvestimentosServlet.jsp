<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fiap.fintech.model.Investimento" %>

<html>
<head>
    <title>Investimentos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1>Investimentos</h1>
        
        <!-- Tabela de investimentos -->
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Valor Inicial</th>
                    <th>Rendimento Acumulado</th>
                    <th>Valor Total Atual</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Investimento> investimentos = (List<Investimento>) request.getAttribute("investimentos");
                    for (Investimento investimento : investimentos) {
                %>
                    <tr>
                        <td><%= investimento.getId_invest() %></td>
                        <td>R$ <%= investimento.getValorInicial() %></td>
                        <td>R$ <%= investimento.getRendimentoAcumulado() %></td>
                        <td>R$ <%= investimento.getValorTotal() %></td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
