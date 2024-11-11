@@ -1,3 +1,5 @@
<%@ page import="br.com.fiap.fintech.model.Transferencias" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
@@ -9,6 +11,12 @@
<link rel="stylesheet" href="./resources/css/bootstrap.css">
<link rel="stylesheet" href="./resources/css/home.css">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
<script type="text/javascript">
  // Função que vai redirecionar para a servlet assim que a página carregar
  window.onload = function() {
    window.location.href = "home";  // Substitua 'nomeDaServlet' pelo caminho da sua servlet
  }
</script>
</head>
<body class="bg-dark-subtle">

@@ -72,29 +80,35 @@ height: auto;
<div class="list-group card-transacoes light-border-subtle">
  <h5 class="mb-3">Últimas transações</h5>
  <a href="#" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
    <div>
      <i class="bi bi-cup-straw me-2"></i> Almoço
      <p class="mb-0 text-muted">Alimentação - Crédito</p>
    </div>
    <span class="text-danger">R$ 31,90</span>
  </a>
  <a href="#" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
    <div>
      <i class="bi bi-bus-front me-2"></i> Bilhete único
      <p class="mb-0 text-muted">Transporte - Crédito</p>
    </div>
    <span class="text-danger">R$ 80,00</span>
  </a>
  <a href="#" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
    <div>
      <i class="bi bi-cash-coin me-2"></i> Salário
      <p class="mb-0 text-muted">Salário - Débito</p>
    </div>
    <span class="text-success">R$ 3.000,00</span>
  </a>
  <tbody>
  <%
    // Recupera a lista de transferências do atributo da requisição
    List<Transferencias> ultimasTransferencias = (List<Transferencias>) request.getAttribute("ultimasTransferencias");

    // Verifica se a lista não está vazia
    if (ultimasTransferencias != null && !ultimasTransferencias.isEmpty()) {
      // Itera sobre cada objeto Transferencia na lista
      for (Transferencias transferencia : ultimasTransferencias) {
  %>
  <tr>
    <!-- Exibe os dados de cada Transferencia na tabela -->
    <td><%= transferencia.getData() %></td>
    <td><%= transferencia.getTipo() %></td>
    <td><%= transferencia.getValor() %></td>
  </tr>
  <%
    }  // Fim do loop
  } else {
  %>
  <tr>
    <td colspan="3">Nenhuma transferência encontrada.</td>
  </tr>
  <%
    }  // Fim do if
  %>
  </tbody>
</div>
</div>

<script src="resources/js/bootstrap.js"></script>
</body>
</html>