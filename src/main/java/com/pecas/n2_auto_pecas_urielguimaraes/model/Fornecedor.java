package com.pecas.n2_auto_pecas_urielguimaraes.model;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

    private int id;
    private String nome;
    private List<Produto> produtosFornecidos = new ArrayList();

    Fornecedor(){
        this.id = this.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarProdutoFornecido(Produto novoProduto){
        this.produtosFornecidos.add(novoProduto);
    }

    public void removerProdutoFornecido(Produto produtoRemovido){
        this.produtosFornecidos.remove(produtoRemovido);
    }

}
