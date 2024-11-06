package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.Transferencia;
import java.util.List;

public interface TransferenciaDao {
    void insert(Transferencia transferencia);
    Transferencia getById(int id);
    List<Transferencia> getAll();
    void update(Transferencia transferencia);
    void delete(int id);
}
