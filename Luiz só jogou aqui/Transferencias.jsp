<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fiap.fintech.model.Transferencia" %>

<html>
<head>
    <title>Transferências</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1>Transferências</h1>
        
        <!-- Lista de transferências -->
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Data</th>
                    <th>Valor</th>
                    <th>Conta Origem</th>
                    <th>Conta Destino</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Transferencia> transferencias = (List<Transferencia>) request.getAttribute("transferencias");
                    for (Transferencia transferencia : transferencias) {
                %>
                    <tr>
                        <td><%= transferencia.getId() %></td>
                        <td><%= transferencia.getData() %></td>
                        <td><%= transferencia.getValor() %></td>
                        <td><%= transferencia.getContaOrigem() %></td>
                        <td><%= transferencia.getContaDestino() %></td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <!-- Paginação -->
        <nav>
            <ul class="pagination justify-content-center">
                <%
                    int currentPage = (int) request.getAttribute("currentPage");
                    int totalPages = (int) request.getAttribute("totalPages");

                    for (int i = 1; i <= totalPages; i++) {
                        String activeClass = (i == currentPage) ? "active" : "";
                %>
                    <li class="page-item <%= activeClass %>">
                        <a class="page-link" href="transferencias?page=<%= i %>"><%= i %></a>
                    </li>
                <%
                    }
                %>
            </ul>
        </nav>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
