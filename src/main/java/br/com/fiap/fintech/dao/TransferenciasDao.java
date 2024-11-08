package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Transferencias;
import java.util.List;

public interface TransferenciasDao {
    void cadastrar(Transferencias transferencias) throws DBException;
    void atualizar(Transferencias transferencias) throws DBException;
    void remover(int id) throws DBException;
    Transferencias buscar(int id);
    List<Transferencias> listar();
}
