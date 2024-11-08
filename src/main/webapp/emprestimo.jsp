<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
  <!-- Cabeçalho da página -->
  <div class="emprestimo-header text-center mb-4">
    <h3>Gestão de Empréstimos</h3>
    <p class="text-muted">Visualize e gerencie seus empréstimos</p>
  </div>

  <!-- Tabela de Empréstimos Ativos -->
  <div class="table-responsive mb-4">
    <h4>Empréstimos Ativos</h4>
    <table class="table table-striped table-hover">
      <thead class="table-secondary">
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Nome do Empréstimo</th>
        <th scope="col">Valor</th>
        <th scope="col">Data de Empréstimo</th>
        <th scope="col">Taxa de Juros</th>
        <th scope="col">Prazo (meses)</th>
        <th scope="col" class="text-end">Status</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>1</td>
        <td>Empréstimo Pessoal</td>
        <td>R$ 10.000,00</td>
        <td>05/11/2024</td>
        <td>2,5%</td>
        <td>24</td>
        <td class="text-end"><span class="badge bg-success">Ativo</span></td>
      </tr>
      <tr>
        <td>2</td>
        <td>Empréstimo para Negócios</td>
        <td>R$ 25.000,00</td>
        <td>10/10/2024</td>
        <td>3,0%</td>
        <td>36</td>
        <td class="text-end"><span class="badge bg-warning text-dark">Em andamento</span></td>
      </tr>
      </tbody>
    </table>
  </div>

  <!-- Formulário para Registrar Novo Empréstimo -->
  <div class="card">
    <div class="card-header">
      <h4>Registrar Novo Empréstimo</h4>
    </div>
    <div class="card-body">
      <form action="RegistrarEmprestimoServlet" method="post">
        <div class="mb-3">
          <label for="nomeEmprestimo" class="form-label">Nome do Empréstimo</label>
          <input type="text" class="form-control" id="nomeEmprestimo" name="nomeEmprestimo" required>
        </div>
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
          <label for="prazoMeses" class="form-label">Prazo de Pagamento (meses)</label>
          <input type="number" class="form-control" id="prazoMeses" name="prazoMeses" required>
        </div>
        <button type="submit" class="btn btn-primary">Registrar Empréstimo</button>
      </form>
    </div>
  </div>
</div>

<script src="./resources/js/bootstrap.js"></script>
</body>
</html>