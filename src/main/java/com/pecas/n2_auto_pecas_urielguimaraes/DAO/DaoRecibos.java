package com.pecas.n2_auto_pecas_urielguimaraes.DAO;

import com.pecas.n2_auto_pecas_urielguimaraes.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaoRecibos extends PostgresqlDAO implements DAO<Recibo>{
    private List<Recibo> listaVendas = new ArrayList<Recibo>();

    @Override
    public List<Recibo> listar() throws Exception {

        String sql = "select * from recibos";
        PreparedStatement ps = getPreparedStatement(sql, false);
        ResultSet rs = ps.executeQuery();

        List<Recibo> recibosDao = new ArrayList<Recibo>();

        while (rs.next()) {
            Recibo recibo = new Recibo();
            recibo.setId(rs.getInt("id"));
            recibo.setVenda(rs.getBoolean("venda"));
            if(recibo.isVenda()){
                recibo.setOperadorVenda(new OperadorVendas(Integer.parseInt(rs.getString("id_operador_vendas"))));
            }else{
                recibo.setOperadorEstoque(new OperadorEstoque(Integer.parseInt(rs.getString("id_operador_estoque"))));
            }
            recibo.setDataVenda(Double.toString(rs.getDouble("data")));
            recibo.setValorTotal(rs.getDouble("total"));

            recibosDao.add(recibo);
        }

        return recibosDao;
    }

    @Override
    public void gravar(Recibo recibo) throws Exception {

        if(recibo.isVenda() == false){
            for(int i=0; i< recibo.getUnidadesVendidas().size(); i++){
                String sqlUnidadesCompradas = "INSERT INTO unidades_produto (id, nome_produto, id_produto) VALUES (?, ?, ?)";
                PreparedStatement psUnidadesCompradas = getPreparedStatement(sqlUnidadesCompradas, true);
                psUnidadesCompradas.setInt(1, recibo.getUnidadesVendidas().get(i).getId());
                psUnidadesCompradas.setString(2, recibo.getUnidadesVendidas().get(i).getProduto().getNome());
                psUnidadesCompradas.setInt(3, recibo.getUnidadesVendidas().get(i).getProduto().getId());

                psUnidadesCompradas.executeUpdate();
                ResultSet rsUnidades = psUnidadesCompradas.getGeneratedKeys();
                rsUnidades.next();
            }
        }

        if(recibo.getOperadorVenda() != null){
            String sqlProduto = "INSERT INTO recibos (id, id_operador_vendas, data, total, venda) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = getPreparedStatement(sqlProduto, true);
            ps.setInt(1, recibo.getId());
            ps.setInt(2, recibo.getOperadorVenda().getId());
            ps.setDouble(3, Double.parseDouble(recibo.getDataVenda()));
            ps.setDouble(4, recibo.getValorTotal());
            ps.setBoolean(5, recibo.isVenda());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        }else{
            String sqlProduto = "INSERT INTO recibos (id, id_operador_estoque, data, total, venda) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = getPreparedStatement(sqlProduto, true);
            ps.setInt(1, recibo.getId());
            ps.setInt(2, recibo.getOperadorEstoque().getId());
            ps.setDouble(3, Double.parseDouble(recibo.getDataVenda()));
            ps.setDouble(4, recibo.getValorTotal());
            ps.setBoolean(5, recibo.isVenda());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        }

        for(int i=0; i< recibo.getUnidadesVendidas().size(); i++){
            String sqlUnidadesVendidas = "INSERT INTO unidades_produto_recibo (id_recibo, id_unidade) VALUES (?,?)";
            PreparedStatement psUnidadesVendidas = getPreparedStatement(sqlUnidadesVendidas, true);
            psUnidadesVendidas.setInt(1, recibo.getId());
            psUnidadesVendidas.setInt(2, recibo.getUnidadesVendidas().get(i).getId());

            psUnidadesVendidas.executeUpdate();
            ResultSet rsUnidades = psUnidadesVendidas.getGeneratedKeys();
            rsUnidades.next();
        }
    }

    @Override
    public void alterar(Recibo value) throws Exception {

    }

    @Override
    public void excluir(Recibo value) throws Exception {

    }
}
