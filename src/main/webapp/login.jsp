<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>LoginPage - EzyPay</title>
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

<div class="container h-100">
    <div class="row justify-content-sm-center h-100">
        <div class="text-center">
            <img src="./resources/image/logoEzy.jpg" alt="logo" id="img-logo">
        </div>
        <div class="text-center">
            <img src="./resources/image/EzyPayBanner-removebg.png" alt="banner" id="img-banner">
        </div>
        <div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
            <div class="card shadow-lg">
                <div class="card-body p-5">
                    <h1 class="fs-4 card-title fw-bold mb-4">Login</h1>

                    <c:if test="${empty user}">

                        <span class="navbar-text text-danger" style="margin-right: 10px">
                            ${erro}
                        </span>

                        <form method="post" action="login" class="needs-validation" novalidate="" autocomplete="off">
                            <div class="mb-3">
                                <label class="mb-2 text-muted" for="email">Email</label>
                                <input id="email" type="email" class="form-control" name="email" required autofocus>
                            </div>

                            <div class="mb-3">
                                <div class="mb-2 w-100">
                                    <label class="text-muted" for="password">Senha</label>
                                </div>
                                <input id="password" type="password" class="form-control" name="password" required>
                            </div>

                            <div class="d-flex align-items-center">
                                <div class="form-check">
                                    <input type="checkbox" name="remember" id="remember" class="form-check-input">
                                    <label for="remember" class="form-check-label">Manter Conectado</label>
                                </div>
                                <button type="submit" class="btn btn-primary ms-auto">
                                    Login
                                </button>
                            </div>
                        </form>

                </div>
                <div class="card-footer py-3 border-0">

                    <div class="text-center">
                        Tendo problemas para acessar?
                        <a href="#"
                           class="text-success"
                           data-bs-toggle="modal"
                           data-bs-target="#excluirModal">
                            Clique Aqui
                        </a>
                        para falar com o nosso suporte.
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<div class="modal fade" id="excluirModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Aviso!</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h4>Lamentamos em dizer que estamos sem suporte no momento.</h4>
            </div>
        </div>
    </div>
</div>
<div style="margin-bottom: 50px"></div>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
