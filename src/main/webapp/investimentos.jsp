<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Investimentos</title>
    <!-- Link do Bootstrap local -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container my-5">
    <h1 class="text-center mb-4">Gerenciamento de Investimentos</h1>

    <!-- Tabela de Investimentos -->
    <div class="mb-4">
        <h3>Investimentos Ativos</h3>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome do Investimento</th>
                <th scope="col">Valor Investido</th>
                <th scope="col">Data</th>
                <th scope="col">Status</th>
            </tr>
            </thead>
            <tbody>
            <!-- Exemplo de dados, você deve popular dinamicamente a partir do seu backend -->
            <tr>
                <td>1</td>
                <td>Investimento A</td>
                <td>R$ 5.000,00</td>
                <td>10/11/2024</td>
                <td><span class="badge badge-success">Ativo</span></td>
            </tr>
            <tr>
                <td>2</td>
                <td>Investimento B</td>
                <td>R$ 3.000,00</td>
                <td>12/11/2024</td>
                <td><span class="badge badge-warning">Em andamento</span></td>
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
                <div class="form-group">
                    <label for="nomeInvestimento">Nome do Investimento</label>
                    <input type="text" class="form-control" id="nomeInvestimento" name="nomeInvestimento" required>
                </div>
                <div class="form-group">
                    <label for="valorInvestido">Valor Investido</label>
                    <input type="number" class="form-control" id="valorInvestido" name="valorInvestido" required>
                </div>
                <div class="form-group">
                    <label for="dataInvestimento">Data do Investimento</label>
                    <input type="date" class="form-control" id="dataInvestimento" name="dataInvestimento" required>
                </div>
                <button type="submit" class="btn btn-primary">Adicionar Investimento</button>
            </form>
        </div>
    </div>

</div>


<script src="./resources/js/bootstrap.min.js"></script>
</body>

</html>
