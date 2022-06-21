package com.pecas.n2_auto_pecas_urielguimaraes.model;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private List<UnidadeProduto> unidadesProduto = new ArrayList();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int quantidadeEmEstoque(){
        return unidadesProduto.size();
    }

    public void adicionarUnidade(UnidadeProduto unidadeProduto){
        unidadesProduto.add(unidadeProduto);
    }

    public void removerUnidade(UnidadeProduto unidadeProduto){
        unidadesProduto.remove(unidadeProduto);
    }

    public void RemoverUltimaUnidade(){
        if(quantidadeEmEstoque() > 0){
            unidadesProduto.remove(quantidadeEmEstoque() -1);
        }else{
            System.out.println("Sem unidades em estoque");
        }
    }
}
