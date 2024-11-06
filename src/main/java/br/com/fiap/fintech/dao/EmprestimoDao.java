package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.Emprestimo;
import java.util.List;

public interface EmprestimoDao {
    void insert(Emprestimo emprestimo);
    Emprestimo getById(int id);
    List<Emprestimo> getAll();
    void update(Emprestimo emprestimo);
    void delete(int id);
}
