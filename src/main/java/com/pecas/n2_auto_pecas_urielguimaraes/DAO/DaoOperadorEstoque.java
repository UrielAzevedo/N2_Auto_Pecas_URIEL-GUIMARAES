package com.pecas.n2_auto_pecas_urielguimaraes.DAO;

import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorEstoque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DaoOperadorEstoque extends PostgresqlDAO implements DAO<OperadorEstoque>{

    @Override
    public List<OperadorEstoque> listar() throws Exception {
        String sql = "select * from operadores_estoque order by nome";
        PreparedStatement ps = getPreparedStatement(sql, false);
        ResultSet rs = ps.executeQuery();

        List<OperadorEstoque> OperadoresEstoqueDao = new ArrayList<OperadorEstoque>();
        while (rs.next()) {
            OperadorEstoque operadorEstoque = new OperadorEstoque();
            operadorEstoque.setNome(rs.getString("nome"));
            operadorEstoque.setId(rs.getInt("id"));
            OperadoresEstoqueDao.add(operadorEstoque);
        }

        return OperadoresEstoqueDao;
    }

    @Override
    public void gravar(OperadorEstoque operadorEstoque) throws Exception {
        String sql = "INSERT INTO operadores_estoque (nome, id) VALUES (?, ?)";
        PreparedStatement ps = getPreparedStatement(sql, true);
        ps.setString(1, operadorEstoque.getNome());
        ps.setInt(2, operadorEstoque.getId());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();

    }

    @Override
    public void alterar(OperadorEstoque value) throws Exception {

    }

    @Override
    public void excluir(OperadorEstoque operadorEstoque) throws Exception {
        String sql = "delete from operadores_estoque where id = ?";
        PreparedStatement ps = getPreparedStatement(sql, false);
        ps.setInt(1, operadorEstoque.getId());
        ps.executeUpdate();
    }
}
