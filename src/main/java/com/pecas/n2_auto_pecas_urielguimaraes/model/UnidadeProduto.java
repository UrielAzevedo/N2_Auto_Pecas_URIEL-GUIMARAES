package com.pecas.n2_auto_pecas_urielguimaraes.model;

public class UnidadeProduto {

    private int id;
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public UnidadeProduto(){
        this.id = this.hashCode();
    }

    public UnidadeProduto(Produto produto){
        this.id = this.hashCode();
        this.produto = produto;
    }

    public int getId() {
        return this.id;
    }

    public void setId (int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "UnidadeProduto{" +
                "id=" + id +
                ", produto=" + produto +
                '}';
    }
}
