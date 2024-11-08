package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Cliente;
import java.util.List;

public interface ClienteDao {
    void cadastrar(Cliente cliente) throws DBException;
    void atualizar(Cliente cliente) throws DBException;
    void remover(int id) throws DBException;
    Cliente buscar(int id);
    List<Cliente> listar();
}
