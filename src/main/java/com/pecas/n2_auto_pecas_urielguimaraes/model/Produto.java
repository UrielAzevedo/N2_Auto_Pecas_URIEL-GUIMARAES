package com.pecas.n2_auto_pecas_urielguimaraes.model;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private List<UnidadeProduto> unidadesProduto = new ArrayList();

    public Produto () {
        this.id = this.hashCode();
    }

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

    public void adicionarUnidades (int quantidade, Produto produto) {

        for (int i = 0; i <= quantidade -1; i++) {
            UnidadeProduto unidadeProduto = new UnidadeProduto(produto);
            unidadesProduto.add(unidadeProduto);

        }
    }

    public List<UnidadeProduto> getUnidadesProduto () {
        return this.unidadesProduto;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setUnidadesProduto (List<UnidadeProduto> unidadesProduto) {
        this.unidadesProduto = unidadesProduto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", unidadesProduto=" + quantidadeEmEstoque() +
                '}';
    }
}
