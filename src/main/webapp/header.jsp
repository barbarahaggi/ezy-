<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>

    .navbar-custom {
        background-color: #08444f;
    }


    .logo-img {
        width: 70px;
        max-width: 100%;
        height: auto;
    }

</style>

<nav class="navbar navbar-dark navbar-expand-lg navbar-custom">
    <div class="container-fluid">
        <img class="logo-img" src="./resources/image/logoEzy.jpg">
        <a class="navbar-brand" href="login.jsp">EzyPay</a>
        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div
                class="collapse navbar-collapse"
                id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link"
                       aria-current="page"
                       href="home.jsp">Início
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="extrato.jsp">Extrato</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="investimentos.jsp">Investimentos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="emprestimo.jsp">Empréstimo</a>
                </li>
            </ul>
        </div>
    </div>
</nav>