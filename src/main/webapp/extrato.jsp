<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ezypay - Extrato</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Roboto', sans-serif;
        }
        .extrato-header {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
        }

    </style>
</head>
<body>

<%@ include file="header.jsp" %>

<div class="container mt-5">
    <!-- Cabeçalho da página -->
    <div class="extrato-header text-center mb-4">
        <h3>Extrato de Transações</h3>
        <p class="text-muted">Visualize suas últimas movimentações</p>
    </div>

    <!-- Tabela de transações -->
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead class="table-secondary">
            <tr>
                <th scope="col">Data</th>
                <th scope="col">Descrição</th>
                <th scope="col">Categoria</th>
                <th scope="col" class="text-end">Valor (R$)</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>10/11/2024</td>
                <td>Almoço em restaurante</td>
                <td>Alimentação</td>
                <td class="text-end text-danger">- 45,00</td>
            </tr>
            <tr>
                <td>09/11/2024</td>
                <td>Salário mensal</td>
                <td>Rendimentos</td>
                <td class="text-end text-success">+ 3.000,00</td>
            </tr>
            <tr>
                <td>08/11/2024</td>
                <td>Compra de livros</td>
                <td>Educação</td>
                <td class="text-end text-danger">- 120,50</td>
            </tr>
            <tr>
                <td>05/11/2024</td>
                <td>Bilhete de transporte</td>
                <td>Transporte</td>
                <td class="text-end text-danger">- 80,00</td>
            </tr>
            <tr>
                <td>02/11/2024</td>
                <td>Reembolso</td>
                <td>Outros</td>
                <td class="text-end text-success">+ 150,00</td>
            </tr>

            <tr>
                <td>12/11/2024</td>
                <td>Supermercado</td>
                <td>Compras</td>
                <td class="text-end text-danger">- 250,75</td>
            </tr>
            <tr>
                <td>11/11/2024</td>
                <td>Pagamento de aluguel</td>
                <td>Moradia</td>
                <td class="text-end text-danger">- 1.200,00</td>
            </tr>
            <tr>
                <td>11/11/2024</td>
                <td>Venda de eletrônicos usados</td>
                <td>Rendimentos</td>
                <td class="text-end text-success">+ 500,00</td>
            </tr>
            <tr>
                <td>07/11/2024</td>
                <td>Assinatura de streaming</td>
                <td>Entretenimento</td>
                <td class="text-end text-danger">- 49,90</td>
            </tr>
            <tr>
                <td>03/11/2024</td>
                <td>Restituição de imposto</td>
                <td>Rendimentos</td>
                <td class="text-end text-success">+ 300,00</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<script src="./resources/js/bootstrap.js"></script>
</body>
</html>
