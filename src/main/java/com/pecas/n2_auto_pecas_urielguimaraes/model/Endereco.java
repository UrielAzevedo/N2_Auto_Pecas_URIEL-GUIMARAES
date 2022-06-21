package com.pecas.n2_auto_pecas_urielguimaraes.model;

public class Endereco {
    private String cep;
    private String endereco;
    private String numero;

    Endereco(String cep, String endereco, String numero){
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}