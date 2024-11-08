<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Navbar com Bootstrap -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        
        <!-- Botão com o nome do usuário no canto esquerdo -->
        <a class="navbar-brand" href="perfil.jsp">
            <%= request.getAttribute("nomeUsuario") != null ? request.getAttribute("nomeUsuario") : "Usuário" %>
        </a>

        <!-- Botão de alternância para dispositivos móveis -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Links de navegação centrais -->
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <a class="nav-link" href="dashboard.jsp">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="investimentos.jsp">Investimentos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="receitas.jsp">Receitas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="despesas.jsp">Despesas</a>
                </li>
            </ul>

            <!-- Botão de logoff no canto direito -->
            <a class="btn btn-outline-light" href="login.jsp">Logoff</a>
        </div>
    </div>
</nav>

<!-- Bootstrap CSS e JS (CDN) -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
