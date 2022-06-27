package com.pecas.n2_auto_pecas_urielguimaraes.DAO;

import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.model.Produto;
import com.pecas.n2_auto_pecas_urielguimaraes.model.UnidadeProduto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoProduto extends PostgresqlDAO implements DAO<Produto> {

    @Override
    public List<Produto> listar() throws Exception {

        String sql = "select * from produto order by nome";
        PreparedStatement ps = getPreparedStatement(sql, false);
        ResultSet rs = ps.executeQuery();

        List<Produto> produtosDao = new ArrayList<Produto>();

        while (rs.next()) {
            List<UnidadeProduto> unidadeProdutos = new ArrayList<UnidadeProduto>();

            Produto produto = new Produto();

            produto.setNome(rs.getString("nome"));
            produto.setId(rs.getInt("id"));
            produto.setPreco(rs.getDouble("preco"));

            String sqlUnidade = "select * from unidades_produto where id_produto = ?";
            PreparedStatement psUnidades = getPreparedStatement(sqlUnidade, false);
            psUnidades.setInt(1, produto.getId());
            ResultSet rsUnidades = psUnidades.executeQuery();

            while(rsUnidades.next()) {
                UnidadeProduto unidadeProduto = new UnidadeProduto();

                unidadeProduto.setId(rsUnidades.getInt("id"));
                unidadeProduto.setProduto(produto);

                unidadeProdutos.add(unidadeProduto);
            }

            produto.setUnidadesProduto(unidadeProdutos);
            produtosDao.add(produto);
        }

        return produtosDao;
    }

    @Override
    public void gravar(Produto produto) throws Exception {

        String sqlProduto = "INSERT INTO produto (id, nome, preco, quantidade_estoque) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = getPreparedStatement(sqlProduto, true);
        ps.setInt(1, produto.getId());
        ps.setString(2, produto.getNome());
        ps.setDouble(3, produto.getPreco());
        ps.setDouble(4, produto.quantidadeEmEstoque());

        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();

        for (int i = 0; i <= produto.quantidadeEmEstoque() -1; i++){

            String sqlUnidadeProduto = "INSERT INTO unidades_produto (id, nome_produto, id_produto) VALUES (?, ?, ?)";
            PreparedStatement psProduto = getPreparedStatement(sqlUnidadeProduto, true);
            psProduto.setInt(1, produto.getUnidadesProduto().get(i).getId());
            psProduto.setString(2, produto.getNome());
            psProduto.setInt(3, produto.getId());

            psProduto.executeUpdate();
            ResultSet rsUnidades = psProduto.getGeneratedKeys();
            rsUnidades.next();

        }


    }

    @Override
    public void alterar(Produto value) throws Exception {

    }

    @Override
    public void excluir(Produto produto) throws Exception {

        String sqlDeleteUnidades = "delete from unidades_produto where id_produto = ?";
        PreparedStatement psUnidades = getPreparedStatement(sqlDeleteUnidades, false);
        psUnidades.setInt(1, produto.getId());
        psUnidades.executeUpdate();

        String sqlDeleteProduto = "delete from produto where id = ?";
        PreparedStatement psProduto = getPreparedStatement(sqlDeleteProduto, false);
        psProduto.setInt(1, produto.getId());
        psProduto.executeUpdate();

    }
}
