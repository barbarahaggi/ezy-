package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Emprestimo;
import java.util.List;

public interface EmprestimoDao {
    void cadastrar(Emprestimo emprestimo) throws DBException;
    void atualizar(Emprestimo emprestimo) throws DBException;
    void remover(int id) throws DBException;
    Emprestimo buscar(int id);
    List<Emprestimo> listar();
}
