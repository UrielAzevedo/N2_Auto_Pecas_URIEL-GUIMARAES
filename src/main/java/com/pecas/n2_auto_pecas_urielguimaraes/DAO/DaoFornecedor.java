package com.pecas.n2_auto_pecas_urielguimaraes.DAO;

import com.pecas.n2_auto_pecas_urielguimaraes.model.Fornecedor;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorEstoque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoFornecedor extends PostgresqlDAO implements DAO<Fornecedor>{

    @Override
    public List<Fornecedor> listar() throws Exception {
        String sql = "select * from fornecedor order by nome";
        PreparedStatement ps = getPreparedStatement(sql, false);
        ResultSet rs = ps.executeQuery();

        List<Fornecedor> FornecedoresDao = new ArrayList<Fornecedor>();
        while (rs.next()) {
            Fornecedor fornecedores = new Fornecedor();
            fornecedores.setNome(rs.getString("nome"));
            fornecedores.setId(rs.getInt("id"));
            FornecedoresDao.add(fornecedores);
        }

        return FornecedoresDao;
    }

    @Override
    public void gravar(Fornecedor fornecedor) throws Exception {
        String sql = "INSERT INTO fornecedor (id, nome, id_produto) VALUES (?, ?, ?)";
        PreparedStatement ps = getPreparedStatement(sql, true);
        ps.setInt(1, fornecedor.getId());
        ps.setString(2, fornecedor.getNome());
        ps.setInt(3, fornecedor.getProduto().get(0).getId());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
    }

    @Override
    public void alterar(Fornecedor value) throws Exception {

    }

    @Override
    public void excluir(Fornecedor fornecedor) throws Exception {
        String sql = "delete from fornecedor where id = ?";
        PreparedStatement ps = getPreparedStatement(sql, false);
        ps.setInt(1, fornecedor.getId());
        ps.executeUpdate();

    }
}
