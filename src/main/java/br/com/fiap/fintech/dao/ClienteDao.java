package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.Cliente;
import java.util.List;

public interface ClienteDao {
    void insert(Cliente cliente);
    Cliente getById(int id);
    List<Cliente> getAll();
    void update(Cliente cliente);
    void delete(int id);
}
