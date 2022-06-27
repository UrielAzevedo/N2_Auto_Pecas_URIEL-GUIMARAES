package com.pecas.n2_auto_pecas_urielguimaraes.DAO;

import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorEstoque;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorVendas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoOperadoresVendas extends PostgresqlDAO implements DAO<OperadorVendas>{


    @Override
    public List<OperadorVendas> listar() throws Exception {
        String sql = "select * from operadores_vendas order by nome";
        PreparedStatement ps = getPreparedStatement(sql, false);
        ResultSet rs = ps.executeQuery();

        List<OperadorVendas> operadorVendasDao = new ArrayList<OperadorVendas>();
        while (rs.next()) {
            OperadorVendas operadorVendas = new OperadorVendas();
            operadorVendas.setNome(rs.getString("nome"));
            operadorVendas.setId(rs.getInt("id"));
            operadorVendasDao.add(operadorVendas);
        }

        return operadorVendasDao;
    }

    @Override
    public void gravar(OperadorVendas operadorVendas) throws Exception {
        String sql = "INSERT INTO operadores_vendas (nome, id) VALUES (?, ?)";
        PreparedStatement ps = getPreparedStatement(sql, true);
        ps.setString(1, operadorVendas.getNome());
        ps.setInt(2, operadorVendas.getId());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
    }

    @Override
    public void alterar(OperadorVendas value) throws Exception {

    }

    @Override
    public void excluir(OperadorVendas operadorVendas) throws Exception {
        String sql = "delete from operadores_vendas where id = ?";
        PreparedStatement ps = getPreparedStatement(sql, false);
        ps.setInt(1, operadorVendas.getId());
        ps.executeUpdate();

    }
}
