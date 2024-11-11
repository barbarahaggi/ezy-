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
    <script type="text/javascript">
        window.onload = function () {
            window.location.href = "home";
        }
    </script>
</head>
<body class="bg-dark-subtle">

<%@include file="header.jsp" %>

<div class="container mt-4">
    <div class="header light-border-subtle">
        <div class="d-flex justify-content-between align-items-center">
            <div class="d-flex align-items-center">
                <img src="resources/image/profile-icon.png" class="rounded-circle me-3 logo-img bg-dark-subtle"
                     alt="Foto de Perfil">
                <h5 class="mb-0">Bom dia, <strong>Admin</strong></h5>
            </div>
            <div>
                <i class="bi bi-bell icon"></i>
            </div>
        </div>
    </div>

    <div class="card mb-3 saldo-card">
        <div class="card-body text-center">
            <h6 class="text-muted">Saldo atual</h6>
            <h3>R$ 10.234,56</h3>
            <a href="transferencias" class="text-decoration-none">Extrato></a>
        </div>
    </div>

    <h5 class="mb-3">Últimas transações</h5>

    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead class="table-secondary">
            <tr>
                <th scope="col">Data</th>
                <th scope="col">Categoria</th>
                <th scope="col" class="text-end">Valor (R$)</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Transferencias> ultimasTransferencias = (List<Transferencias>) request.getAttribute("ultimasTransferencias");

                if (ultimasTransferencias != null && !ultimasTransferencias.isEmpty()) {
                    for (Transferencias transferencia : ultimasTransferencias) {
            %>
            <tr>
                <td><%= transferencia.getData() %></td>
                <td><%= transferencia.getTipo() %></td>
                <td class="text-end"><%= transferencia.getValor() %></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="3" class="text-center">Nenhuma transferência encontrada.</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<script src="resources/js/bootstrap.js"></script>
</body>
</html>
