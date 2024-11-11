<%@ page import="br.com.fiap.fintech.model.Transferencias" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>Ezypay - home</title>
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

<style>
  .logo-img {
    width: 70px;
    max-width: 100%;
    height: auto;
  }
</style>

<%@include file="header.jsp" %>


<%-- Container principal --%>
<div class="container mt-4">
  <div class="header light-border-subtle">
    <div class="d-flex justify-content-between align-items-center">
      <div class="d-flex align-items-center">
        <img src="resources/image/profile-icon.png" class="rounded-circle me-3 logo-img bg-dark-subtle" alt="Foto de Perfil">
        <h5 class="mb-0">Bom dia, <strong>Barbara Oliveira</strong></h5>
      </div>
      <div>
        <i class="bi bi-bell icon"></i>
      </div>
    </div>
  </div>


  <%-- Cartão de saldo atual --%>
  <div class="card mb-3 saldo-card">
    <div class="card-body text-center">
      <h6 class="text-muted">Saldo atual</h6>
      <h3>R$ 1.234,56</h3>
      <a href="transferencias" class="text-decoration-none">Extrato></a>
    </div>
  </div>

  <%-- Cartões de receitas e despesas --%>
  <div class="row mb-3">
    <div class="col">
      <div class="card text-center saldo-card bg-success-subtle text-success-emphasis">
        <div class="card-body">
          <h6>Receitas</h6>
          <h4>R$ 3.000,00</h4>
        </div>
      </div>
    </div>
    <div class="col">
      <div class="card text-center saldo-card bg-danger-subtle text-danger-emphasis">
        <div class="card-body">
          <h6>Despesas</h6>
          <h4>R$ 1.765,44</h4>
        </div>
      </div>
    </div>
  </div>

  <%-- Lista de transações --%>

  <div class="list-group card-transacoes light-border-subtle">
    <h5 class="mb-3">Últimas transações</h5>
    <a href="#" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
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
        }  // Fim do iif
      %>
      </tbody>
  </div>
</div>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
