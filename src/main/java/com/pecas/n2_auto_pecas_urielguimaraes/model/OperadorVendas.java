package com.pecas.n2_auto_pecas_urielguimaraes.model;

import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoRecibos;

import java.util.ArrayList;
import java.util.List;

public class OperadorVendas {
    private int id;
    private String nome;
    private List<Endereco> enderecos = new ArrayList();
    private List<Numero> numeros = new ArrayList();
    private DaoRecibos recibosVendasDao = new DaoRecibos();

    public OperadorVendas(){
        this.id = this.hashCode();
    }

    public OperadorVendas (int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private void VenderProduto(List<UnidadeProduto> produtosVendidos){

    }

    private int verificarEstoque(Produto produto){
        return produto.quantidadeEmEstoque();
    }

    @Override
    public String toString() {
        return "OperadorVendas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
