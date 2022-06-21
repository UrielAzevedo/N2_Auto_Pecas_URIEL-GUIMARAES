package com.pecas.n2_auto_pecas_urielguimaraes;

import com.pecas.n2_auto_pecas_urielguimaraes.model.Produto;
import com.pecas.n2_auto_pecas_urielguimaraes.model.UnidadeProduto;

public class Teste {

    public static void main (String args[]){
        Produto p1 = new Produto();
        p1.setNome("lanterna Siena");
        p1.setPreco(60);

        p1.adicionarUnidade(new UnidadeProduto(p1));
        p1.adicionarUnidade(new UnidadeProduto(p1));
        p1.adicionarUnidade(new UnidadeProduto(p1));

        p1.RemoverUltimaUnidade();
        p1.RemoverUltimaUnidade();
        p1.RemoverUltimaUnidade();
        p1.RemoverUltimaUnidade();

        System.out.println(p1.quantidadeEmEstoque());
    }
}
