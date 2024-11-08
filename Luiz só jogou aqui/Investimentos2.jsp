<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fiap.fintech.model.RendimentoDiario" %>

<html>
<head>
    <title>Gráfico de Rendimento Diário</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <div class="container mt-4">
        <h1>Rendimento Diário</h1>

        <!-- Gráfico de Rendimento Diário -->
        <canvas id="rendimentoChart"></canvas>

        <%
            List<RendimentoDiario> rendimentoDiario = (List<RendimentoDiario>) request.getAttribute("rendimentoDiario");
            StringBuilder datas = new StringBuilder();
            StringBuilder rendimentos = new StringBuilder();

            for (RendimentoDiario rendimento : rendimentoDiario) {
                datas.append("'").append(rendimento.getData()).append("',");
                rendimentos.append(rendimento.getRendimento()).append(",");
            }
        %>

        <script>
            const ctx = document.getElementById('rendimentoChart').getContext('2d');
            const rendimentoChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: [<%= datas.toString() %>],
                    datasets: [{
                        label: 'Rendimento Diário',
                        data: [<%= rendimentos.toString() %>],
                        borderColor: 'rgb(75, 192, 192)',
                        fill: false
                    }]
                },
                options: {
                    scales: {
                        x: {
                            type: 'time',
                            time: {
                                unit: 'day'
                            }
                        },
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        </script>
    </div>
</body>
</html>
