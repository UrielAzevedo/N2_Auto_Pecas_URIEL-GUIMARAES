package com.pecas.n2_auto_pecas_urielguimaraes.model;

import java.util.ArrayList;
import java.util.List;

public class OperadorEstoque {
    private int id;
    private String nome;
    private List<Endereco> enderecos = new ArrayList();
    private List<Numero> numeros = new ArrayList();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
