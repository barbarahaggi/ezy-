<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ezypay - Investimentos</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
        }
        .investimento-header {
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
    <div class="investimento-header text-center mb-4">
        <h3>Gerenciamento de Investimentos</h3>
        <p class="text-muted">Visualize e gerencie seus investimentos</p>
    </div>

    <!-- Tabela de Investimentos Ativos -->
    <div class="table-responsive mb-4">
        <h4>Investimentos Ativos</h4>
        <table class="table table-striped table-hover">
            <thead class="table-secondary">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome do Investimento</th>
                <th scope="col">Valor Investido</th>
                <th scope="col">Data</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Investimento A</td>
                <td>R$ 5.000,00</td>
                <td>10/11/2024</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Investimento B</td>
                <td>R$ 3.000,00</td>
                <td>12/11/2024</td>
            </tr>
            </tbody>
        </table>
    </div>

    <!-- Formulário para Adicionar Novo Investimento -->
    <div class="card">
        <div class="card-header">
            <h4>Adicionar Novo Investimento</h4>
        </div>
        <div class="card-body">
            <form action="AdicionarInvestimentoServlet" method="post">
                <div class="mb-3">
                    <label for="nomeInvestimento" class="form-label">Nome do Investimento</label>
                    <input type="text" class="form-control" id="nomeInvestimento" name="nomeInvestimento" required>
                </div>
                <div class="mb-3">
                    <label for="valorInvestido" class="form-label">Valor Investido</label>
                    <input type="number" class="form-control" id="valorInvestido" name="valorInvestido" required>
                </div>
                <div class="mb-3">
                    <label for="dataInvestimento" class="form-label">Data do Investimento</label>
                    <input type="date" class="form-control" id="dataInvestimento" name="dataInvestimento" required>
                </div>
                <button type="submit" class="btn btn-primary">Adicionar Investimento</button>
            </form>
        </div>
    </div>
</div>

<script src="./resources/js/bootstrap.js"></script>
</body>
</html>
