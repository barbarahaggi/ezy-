<%@ page import="br.com.fiap.fintech.model.Transferencias" %>
<%@ page import="java.util.List" %>
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

            font-family: 'Roboto', sans-serif;
        }
        .extrato-header {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
        }

    </style>
</head>
<body class="bg-dark-subtle">

<%@ include file="header.jsp" %>

<div class="container mt-5">
    <!-- Cabeçalho da páginaa -->
    <div class="extrato-header text-center mb-4">
        <h3>Extrato de Transações</h3>
        <p class="text-muted">Visualize suas últimas movimentações</p>
    </div>

    <!-- Tabela de transações -->
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead class="table-secondary">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Tipo</th>
                <th scope="col">Valor (R$)</th>
                <th scope="col">Data</th>
            </tr>
            </thead>
            <%
                List<Transferencias> transferencias = (List<Transferencias>) request.getAttribute("transferencias");
                for (Transferencias transferencia : transferencias) {
            %>
            <tr>
                <td><%= transferencia.getIdTransf() %>
                </td>
                <td><%= transferencia.getTipo() %>
                </td>
                <td><%= transferencia.getValor() %>
                </td>
                <td><%= transferencia.getData() %>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<script src="./resources/js/bootstrap.js"></script>
</body>
</html>
