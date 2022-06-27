package com.pecas.n2_auto_pecas_urielguimaraes.model;

import com.pecas.n2_auto_pecas_urielguimaraes.DAO.RecibosVendasDao;

import java.util.ArrayList;
import java.util.List;

public class OperadorVendas {
    private int id;
    private String nome;
    private List<Endereco> enderecos = new ArrayList();
    private List<Numero> numeros = new ArrayList();
    private RecibosVendasDao recibosVendasDao = new RecibosVendasDao();

    public OperadorVendas(){
        this.id = this.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private void VenderProduto(List<UnidadeProduto> produtosVendidos){
        ReciboVenda reciboVenda = new ReciboVenda(produtosVendidos, this);
        recibosVendasDao.adicionarVenda(reciboVenda);
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
