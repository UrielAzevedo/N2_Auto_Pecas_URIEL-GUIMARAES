package com.pecas.n2_auto_pecas_urielguimaraes.model;

import java.util.List;

public class ReciboVenda {
    private List<UnidadeProduto> unidadesVendidas;
    private OperadorVendas operadorVenda;
    private String dataVenda;
    private double valorTotalVenda;

    ReciboVenda(List<UnidadeProduto> unidadesVendidas, OperadorVendas operadorVenda){
        this.unidadesVendidas = unidadesVendidas;
        this.operadorVenda = operadorVenda;
        this.valorTotalVenda = calcularValorTotalVenda();
    }

    public List<UnidadeProduto> getUnidadesVendidas() {
        return unidadesVendidas;
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

    public double calcularValorTotalVenda(){

        valorTotalVenda = 0;
        this.unidadesVendidas.forEach((unidade) -> {
            valorTotalVenda += unidade.getProduto().getPreco();
        });
        return valorTotalVenda;
    }
}
