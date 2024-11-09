<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>Cadastro de Usuário - EzyPay</title>
  <link rel="stylesheet" href="./resources/css/bootstrap.css">
  <link rel="stylesheet" href="./resources/css/loginpage.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">

  <style>
    body {
      background-color: #08444f;
    }
  </style>
</head>

<body>

<%@include file="header.jsp" %>

<div class="text-center">
  <img src="./resources/image/logoEzy.jpg" alt="logo" id="img-logo">
</div>
<div class="text-center">
  <img src="./resources/image/EzyPayBanner-removebg.png" alt="banner" id="img-banner">
</div>

<div class="container h-100">
  <div class="row justify-content-sm-center h-100">
    <div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
      <div class="card shadow-lg">
        <div class="card-body p-5">
          <h1 class="fs-4 card-title fw-bold mb-4">Cadastro de Usuário</h1>

          <form method="post" action="cadastroUsuario" class="needs-validation" novalidate="" autocomplete="off">
            <div class="mb-3">
              <label class="mb-2 text-muted" for="nome">Nome Completo</label>
              <input id="nome" type="text" class="form-control" name="nome" required>
            </div>

            <div class="mb-3">
              <label class="mb-2 text-muted" for="cpf">CPF</label>
              <input id="cpf" type="text" class="form-control" name="cpf" required>
            </div>

            <div class="mb-3">
              <label class="mb-2 text-muted" for="rg">RG</label>
              <input id="rg" type="text" class="form-control" name="rg" required>
            </div>

            <div class="mb-3">
              <label class="mb-2 text-muted" for="data_nascimento">Data de Nascimento</label>
              <input id="data_nascimento" type="date" class="form-control" name="data_nascimento" required>
            </div>

            <div class="mb-3">
              <label class="mb-2 text-muted" for="telefone">Telefone</label>
              <input id="telefone" type="text" class="form-control" name="telefone">
            </div>

            <div class="d-flex align-items-center">
              <button type="submit" class="btn btn-primary ms-auto">
                Cadastrar
              </button>
            </div>
          </form>
        </div>
        <div class="card-footer py-3 border-0">
          <div class="text-center">
            Já possui uma conta?
            <a href="login.jsp" class="text-success">Faça Login</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
