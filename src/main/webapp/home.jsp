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
</head>
<body class="bg-dark-subtle">

<%@include file="header.jsp" %>

<%-- Container principal --%>
<div class="container mt-4">
  <div class="header light-border-subtle">
    <div class="d-flex justify-content-between align-items-center">
      <div class="d-flex align-items-center">
        <img src="https://via.placeholder.com/50" class="rounded-circle me-3" alt="Foto de Perfil">
        <h5 class="mb-0">Bom dia, <strong>Barbara Oliveira</strong></h5>
      </div>
      <div>
        <i class="bi bi-bell icon"></i>
      </div>
    </div>
  </div>

  <%-- Menu de navegação --%>
  <nav class="nav justify-content-center bg-white py-2 mb-3">
    <a class="nav-link" href="#">Março</a>
    <a class="nav-link active" href="#">Abril</a>
    <a class="nav-link" href="#">Maio</a>
  </nav>

  <%-- Cartão de saldo atual --%>
  <div class="card mb-3 saldo-card">
    <div class="card-body text-center">
      <h6 class="text-muted">Saldo atual</h6>
      <h3>R$ 1.234,56</h3>
      <a href="#" class="text-decoration-none">Extrato></a>
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
  </div>
</div>

<script src="resources/js/bootstrap.js"></script>
</body>
</html>
