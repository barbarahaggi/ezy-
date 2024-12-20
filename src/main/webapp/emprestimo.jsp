<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Ezypay - Empréstimos</title>
  <link rel="stylesheet" href="./resources/css/bootstrap.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
  <style>
    body {
      font-family: 'Roboto', sans-serif;
    }
    .emprestimo-header {
      background-color: #ffffff;
      padding: 20px;
      border-radius: 10px;
    }
  </style>
</head>
<body class="bg-dark-subtle">

<%@ include file="header.jsp" %>

<div class="container mt-5">
  <div class="emprestimo-header text-center mb-4">
    <h3>Gestão de Empréstimos</h3>
    <p class="text-muted">Visualize e gerencie seus empréstimos</p>
  </div>

  <div class="table-responsive mb-4">
    <h4>Empréstimos Ativos</h4>
    <table class="table table-striped table-hover">
      <thead class="table-secondary">
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Valor</th>
        <th scope="col">Data de Empréstimo</th>
        <th scope="col">Data de Vencimento</th>
        <th scope="col">Taxa de Juros</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="emprestimo" items="${emprestimos}">
        <tr>
          <td>${emprestimo.id_empre}</td>
          <td>${emprestimo.valor}</td>
          <td>${emprestimo.data_inicio}</td>
          <td>${emprestimo.data_vencimento}</td>
          <td>${emprestimo.taxa_juros}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>

  <div class="card">
    <div class="card-header">
      <h4>Registrar Novo Empréstimo</h4>
    </div>
    <c:if test="${not empty mensagem}">
      <div class="alert alert-success">${mensagem}</div>
    </c:if>
    <c:if test="${not empty erro}">
      <div class="alert alert-danger">${erro}</div>
    </c:if>

    <div class="card-body">
      <form action="RegistrarEmprestimoServlet" method="post">
        <div class="mb-3">
          <label for="valorEmprestimo" class="form-label">Valor do Empréstimo (R$)</label>
          <input type="number" class="form-control" id="valorEmprestimo" name="valorEmprestimo" required>
        </div>
        <div class="mb-3">
          <label for="dataEmprestimo" class="form-label">Data do Empréstimo</label>
          <input type="date" class="form-control" id="dataEmprestimo" name="dataEmprestimo" required>
        </div>
        <div class="mb-3">
          <label for="taxaJuros" class="form-label">Taxa de Juros (%)</label>
          <input type="number" step="0.1" class="form-control" id="taxaJuros" name="taxaJuros" required>
        </div>
        <div class="mb-3">
          <label for="dataVencimento" class="form-label">Data do Vencimento do Empréstimo</label>
          <input type="date" class="form-control" id="dataVencimento" name="dataVencimento" required>
        </div>
        <button type="submit" class="btn btn-primary">Registrar Empréstimo</button>
      </form>
    </div>
  </div>
</div>

<br>
<br>
<br>

<script src="./resources/js/bootstrap.js"></script>
</body>
</html>
