package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.UsuarioDao;
import br.com.fiap.fintech.dao.impl.OracleUsuarioDao;

public class DaoFactory {
    public static UsuarioDao getUsuarioDao() {
        return new OracleUsuarioDao();
    }
}
