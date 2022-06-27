package com.pecas.n2_auto_pecas_urielguimaraes;

import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoOperadorEstoque;
import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoProduto;
import com.pecas.n2_auto_pecas_urielguimaraes.DAO.PostgresqlDAO;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorEstoque;
import com.pecas.n2_auto_pecas_urielguimaraes.model.Produto;
import com.pecas.n2_auto_pecas_urielguimaraes.model.UnidadeProduto;

import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main (String args[]){

        DaoProduto daoProduto = new DaoProduto();
        List<Produto> produtos = new ArrayList<Produto>();
        try{
            produtos = daoProduto.listar();
        }catch (Exception e){

        }

        System.out.println(produtos.get(0).quantidadeEmEstoque());

//        Produto p1 = new Produto();
//        DaoOperadorEstoque daoEstoque = new DaoOperadorEstoque();
//        OperadorEstoque opeUm = new OperadorEstoque();
//        opeUm.setNome("jorge");
//        p1.setNome("lanterna Siena");
//        p1.setPreco(60);
//
//        try{
//            daoEstoque.gravar(opeUm);
//        } catch (Exception e){
//            System.out.println(e);
//        }
//
//        p1.adicionarUnidade(new UnidadeProduto(p1));
//        p1.adicionarUnidade(new UnidadeProduto(p1));
//        p1.adicionarUnidade(new UnidadeProduto(p1));
//
//        System.out.println(Integer.toString(p1.quantidadeEmEstoque()));

//        p1.RemoverUltimaUnidade();
//        p1.RemoverUltimaUnidade();
//        p1.RemoverUltimaUnidade();
//        p1.RemoverUltimaUnidade();
//
//        try{
//            daoProduto.gravar(p1);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        System.out.println(p1.quantidadeEmEstoque());
    }
}
