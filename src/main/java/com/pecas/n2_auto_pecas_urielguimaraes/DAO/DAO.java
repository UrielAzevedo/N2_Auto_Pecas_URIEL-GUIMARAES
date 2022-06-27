package com.pecas.n2_auto_pecas_urielguimaraes.DAO;

import java.util.List;

public interface DAO<T> {
    public List<T> listar() throws Exception;
    public void gravar(T value) throws Exception;
    public void alterar(T value) throws Exception;
    public void excluir(T value) throws Exception;
}
