package com.pecas.n2_auto_pecas_urielguimaraes.model;

import java.util.ArrayList;
import java.util.List;

public class Recibo {
    private int id;
    private List<UnidadeProduto> unidadesVendidas = new ArrayList<UnidadeProduto>();
    private OperadorVendas operadorVenda;
    private OperadorEstoque operadorEstoque;
    private String dataVenda;
    private double valorTotal;
    private boolean venda;

    public OperadorEstoque getOperadorEstoque() {
        return operadorEstoque;
    }

    public void setOperadorEstoque(OperadorEstoque operadorEstoque) {
        this.operadorEstoque = operadorEstoque;
    }

    public boolean isVenda() {
        return venda;
    }

    public void setVenda(boolean venda) {
        this.venda = venda;
    }

    public Recibo () {
    }

    public Recibo(List<UnidadeProduto> unidadesVendidas, OperadorVendas operadorVenda, double valorTotalVenda, boolean venda){
        this.unidadesVendidas = unidadesVendidas;
        this.operadorVenda = operadorVenda;
        this.valorTotal = calcularValorTotalVenda();
        this.id = this.hashCode();
        this.dataVenda = Long.toString(System.currentTimeMillis());
        this.valorTotal = valorTotalVenda;
        this.venda = venda;
    }

    public Recibo(List<UnidadeProduto> unidadesVendidas, OperadorEstoque operadorEstoque, double valorTotalVenda, boolean venda){
        this.unidadesVendidas = unidadesVendidas;
        this.operadorEstoque = operadorEstoque;
        this.valorTotal = calcularValorTotalVenda();
        this.id = this.hashCode();
        this.dataVenda = Long.toString(System.currentTimeMillis());
        this.valorTotal = valorTotalVenda;
        this.venda = venda;
    }

    public List<UnidadeProduto> getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotalVenda) {
        this.valorTotal = valorTotalVenda;
    }

    public void setUnidadesVendidas(List<UnidadeProduto> unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public OperadorVendas getOperadorVenda() {
        return operadorVenda;
    }

    public void setOperadorVenda(OperadorVendas operadorVenda) {
        this.operadorVenda = operadorVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double calcularValorTotalVenda(){

        valorTotal = 0;
        this.unidadesVendidas.forEach((unidade) -> {
            valorTotal += unidade.getProduto().getPreco();
        });
        return valorTotal;
    }
}
