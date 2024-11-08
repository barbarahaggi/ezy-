package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Investimento;
import java.util.List;

public interface InvestimentoDao {
    void cadastrar(Investimento investimento) throws DBException;
    void atualizar(Investimento investimento) throws DBException;
    void remover(int id) throws DBException;
    Investimento buscar(int id);
    List<Investimento> listar();
}
