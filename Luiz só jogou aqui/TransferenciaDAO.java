public class TransferenciaDao {
    // Exemplo de conexão ao banco de dados (ajuste para seu banco de dados)
    private Connection connection;

    public TransferenciaDao() {
        // Inicialização da conexão com o banco
    }

    public List<Transferencia> getTransferenciasPaginated(int start, int limit) {
        List<Transferencia> transferencias = new ArrayList<>();
        String sql = "SELECT * FROM Transferencias LIMIT ? OFFSET ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, limit);
            stmt.setInt(2, start);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Transferencia transferencia = new Transferencia();
                // Popule o objeto transferencia com os dados do ResultSet
                transferencias.add(transferencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transferencias;
    }

    public int getTotalRecords() {
        int totalRecords = 0;
        String sql = "SELECT COUNT(*) FROM Transferencias";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalRecords = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRecords;
    }
}
